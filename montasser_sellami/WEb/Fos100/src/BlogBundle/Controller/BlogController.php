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

            ;
            $p->uploadProfilePicture();

        }
        return $this->render('@Blog/Blog/Modifier.html.twig', array(
            "form"=> $form->createView()
        ));

    }


    public function voirblogAction($id){

        $em= $this->getDoctrine()->getManager();
        $post=$em->getRepository('BlogBundle:Post')->find($id);
        return $this->render('@Blog/Blog/voir.html.twig',array(
            'sujet'=>$post->getSujet(),
            'contenu'=>$post->getContenu(),
            'post'=>$post,
            'comments'=>$post,



        ));
          }
}
