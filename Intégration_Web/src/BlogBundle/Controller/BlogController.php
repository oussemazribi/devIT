<?php

namespace BlogBundle\Controller;


use BlogBundle\Entity\Post;
use BlogBundle\Entity\Comment;
use BlogBundle\Form\PostType;
use BlogBundle\Form\CommentType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Twilio\Exceptions\ConfigurationException;
use Symfony\Component\Security\Core\User\UserInterface;

class BlogController extends Controller
{
    public function ajoutBlogAction(Request $request)
    {
        $post = new Post();
        $form = $this->createForm(PostType::class, $post);
        $form->handleRequest($request);


        if ($form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            $post->setDateCreation (new \DateTime('now'));
            $photo = $form['file']->getData();
            $post->setSujet ($form['sujet']->getData());
            $post->setContenu($form['contenu']->getData());
            $post->setPhoto($photo);

;
            $post->uploadProfilePicture();



            $em->persist($post);
            $em->flush();
            $this->addFlash('info', 'Created Successfully !');

            return $this->redirectToRoute('blog_afficheBlog');
        }
        return $this->render("@Blog/Blog/Ajout.html.twig", array('form' =>
            $form->createView()));

    }
   public function afficheBlogAction(){
       $em = $this ->getDoctrine()->getManager();
       $post = $em->getRepository("BlogBundle:Post")->findAll();
       return $this->render('@Blog/Blog/Affiche.html.twig', array( 'post'=>$post ));

        }
        public function afficheBlogUserAction(){
        $em = $this ->getDoctrine()->getManager();
        $post = $em->getRepository("BlogBundle:Post")->findAll();
        return $this->render('@Blog/Blog/AfficheBlogUser.html.twig', array( 'post'=>$post ));}

public function supprimerBlogAction($id){
 $em = $this -> getDoctrine()->getManager();
    $post = $em ->getRepository(Post::class)->find($id);
    $em ->remove($post);
    $em->flush();
    return $this->redirectToRoute('blog_afficheBlog');
}


public function modifierBlogAction (Request $request,$id){

        $em=$this->getDoctrine()->getManager();
        $p= $em->getRepository('BlogBundle:Post')->find($id);
        $form=$this->createForm(PostType::class,$p);
        $form->handleRequest($request);
        if($form->isSubmitted()){
            $em = $this->getDoctrine()->getManager();
            $p->setDateCreation (new \DateTime('now'));
            $photo = $form['file']->getData();
            $p->setSujet ($form['sujet']->getData());
            $p->setContenu($form['contenu']->getData());
            $p->setPhoto($photo);
            $p->uploadProfilePicture();
            $em->persist($p);
            $em->flush();
        }
        return $this->render('@Blog/Blog/Modifier.html.twig', array(
            "form"=> $form->createView()
        ));
    return $this->redirectToRoute('blog_afficheBlog');

    }


    public function voirblogAction($id){

        $em= $this->getDoctrine()->getManager();
        $post=$em->getRepository('BlogBundle:Post')->find($id);
        $comment = $em->getRepository('BlogBundle:Comment')->
        findBy(array('post' =>$post));
        return $this->render('@Blog/Blog/voir.html.twig',array(
            'sujet'=>$post->getSujet(),
            'contenu'=>$post->getContenu(),
            'post'=>$post,
            'comments'=>$post,
            'comment'=>$comment



        ));
          }
    public function voirblogUserAction($id){

        $em= $this->getDoctrine()->getManager();
        $post=$em->getRepository('BlogBundle:Post')->find($id);

        $comment = $em->getRepository('BlogBundle:Comment')->
        findBy(array('post' =>$post));
        return $this->render('@Blog/Blog/voirBlogUser.html.twig',array(
            'sujet'=>$post->getSujet(),
            'contenu'=>$post->getContenu(),
            'post'=>$post,
            'comments'=>$post,
            'comment'=>$comment
        ));
    }


    public function addCommentAction(Request $request ,$post_id)
    {

        $user = $this->getUser();
        $comment = new Comment();
        $em = $this->getDoctrine()->getManager();
        $formcom = $this->createForm('BlogBundle\Form\CommentType', $comment);
        $post = $em->getRepository('BlogBundle:Post')->find($post_id);
        $formcom->handleRequest($request);

        $comment->setPost($post);
        $comment->setIdUser($user);
        $comment->setDateCreation(new \DateTime("now", new \DateTimeZone('+0100')));
        $contenu=$request->query->get("contenu");
        $comment->setContenu($contenu);
        $em->persist($comment);
        $em->flush();

        return  $this->redirectToRoute("blog_voirBlogUser",['id'=>$post_id]);
    }


    public function deleteCommentAction(Request $request ,$id)
    {
        $id = $request->get('id');
        $em= $this->getDoctrine()->getManager();
        $comment=$em->getRepository('BlogBundle:comment')->find($id);
        $em->remove($comment);
        $em->flush();
        return $this->redirectToRoute('blog_afficheBlog');
    }
    public function AfficheCommentsAction($id_post)
    {
        $em = $this->getDoctrine()->getManager();

        $comment = $em->getRepository('BlogBundle:Comment')->find($id_post);
        return $this->render('@Blog/Blog/voirBlogUser.html.twig', array(
            'comments' => $comment
        ));
    }
    public function editCommentAction(Request $request,$id)
    {
        $em = $this->getDoctrine()->getManager();
        $comment= $em->getRepository('BlogBundle:comment')->find($id);
        $editFormcom = $this->createForm('BlogBundle\Form\commentType', $comment);
        $editFormcom->handleRequest($request);
        if($request->isXmlHttpRequest())
        {$contenu=$request->request->get("contenu");
            echo "$contenu";
            $comment->setContenue($contenu);}
        $em->persist($comment);
        $em->flush();
        return  $this->redirectToRoute("publication_homepage");
    }


    public function getNbCommentAction($id)
    {
        $em = $this->getDoctrine()->getManager(); //on appelle Doctrine
        $query = $em->createQuery( //creation de la requête
            'SELECT count(*)
    FROM Comment c join  Post 
    WHERE c.post > :post')
    ->setParameter('post', $id);
        $parc = $query->getResult();

        return ['parc' => $parc ];
    }
    public function ModifBlogMAction (Request $request,$id){

        $em=$this->getDoctrine()->getManager();
        $p= $em->getRepository('BlogBundle:Post')->find($id);
        $form=$this->createForm(PostType::class,$p);
        $form->handleRequest($request);
        if($form->isSubmitted()){
            $em = $this->getDoctrine()->getManager();
            $p->setDateCreation (new \DateTime('now'));
            $photo = $form['file']->getData();
            $p->setSujet ($form['sujet']->getData());
            $p->setContenu($form['contenu']->getData());
            $p->setPhoto($photo);
            $p->uploadProfilePicture();
            $em->persist($p);
            $em->flush();
        }
        return $this->render('@Blog/Blog/Modifier.html.twig', array(
            "form"=> $form->createView()
        ));
        return $this->redirectToRoute('blog_afficheBlog');

    }


}
