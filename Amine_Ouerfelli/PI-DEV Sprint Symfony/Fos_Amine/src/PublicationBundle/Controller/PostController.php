<?php

namespace PublicationBundle\Controller;

use PublicationBundle\Entity\Post;
use PublicationBundle\Entity\reaction;
use PublicationBundle\Entity\Vote;
use PublicationBundle\Form\PostType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Form;
use Symfony\Component\Form\FormEvent;
use Symfony\Component\Form\FormEvents;
use Symfony\Component\HttpFoundation\File\File;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class PostController extends Controller
{
    public function AjouterPostVIAction(Request $req)
    {
        $User=$this->getUser();
        $post=new Post();
        $post->setIdauthor($User);
        $post->setDate(new \DateTime("now", new \DateTimeZone('+0100')));
        $post->setReactionPost(0);
        $form=$this->createForm(PostType::class,$post);
        $form->add('contenue', FileType::class, [
            'label' => 'Content(video, text, image)',
            'mapped' => false,
            'required' => false,
            'constraints' => [
                new \Symfony\Component\Validator\Constraints\File([
                    'maxSize' => '1024M',

                    'mimeTypesMessage' => 'Please upload a valid document',
                ])
            ],
        ]);

        $form->handleRequest($req);
        $em=$this->getDoctrine()->getManager();
        if($form->isSubmitted()&&$form->isValid())
        {

            $srcFile = $form->get('contenue')->getData();
            if ($srcFile) {
                $originalFilename = pathinfo($srcFile->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$srcFile->guessExtension();

                try {
                    $srcFile->move('uploads/' . $post->getType(), $newFilename);
                } catch (FileException $e) {
                    print $e->getMessage();
                }
                $post->setSrcPublication($newFilename);

            }

            $em->persist($post);
            $em->flush();



        }
        $posts = $em->getRepository('PublicationBundle:Post')->findBy(array(), array('date'=>'DESC'));
        $comments=$em->getRepository('PublicationBundle:commentaire')->findBy(array());
        $reactions=$em->getRepository('PublicationBundle:reaction')->findBy(array());
        return $this->render('@Publication/Posts/Acceuil.html.twig',array('user'=>$User,'posts'=>$posts,'comments'=>$comments,'reactions'=>$reactions,'form'=>$form->createView()));


    }
    public function DeletePostAction($id_post,Request $request)
    {
        $user = $this->getUser() ;
        $em = $this->getDoctrine()->getManager();
        $publication = $em->getRepository('PublicationBundle:Post')->find($id_post);

        if ($publication && ($publication->getIdauthor()->getId() == $user->getId() || $user->isSuperAdmin() )   ) {
            $em->getRepository('PublicationBundle:commentaire')->removePostCommentaire($id_post);
            $em->remove($publication);
            $em->flush();
        }

        return $this->redirectToRoute("publication_homepage");
    }
    public function ModifierPostAction($id_post,Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $post= $em->getRepository('PublicationBundle:Post')->find($id_post);
        $editform = $this->createForm('PublicationBundle\Form\PostType', $post);

        $editform->add('contenue', FileType::class, [
            'label' => 'Content(video, text, image)',
            'mapped' => false,
            'required' => false,
            'constraints' => [
                new \Symfony\Component\Validator\Constraints\File([
                    'maxSize' => '1024M',

                    'mimeTypesMessage' => 'Please upload a valid document',
                ])
            ],
        ]);
        $editform->handleRequest($request);
        if($editform->isSubmitted()&&$editform->isValid())
        {
            $em=$this->getDoctrine()->getManager();
            $em->persist($post);
            $em->flush();
            return $this->redirectToRoute('publication_homepage');
        }
        $comments=$em->getRepository('PublicationBundle:commentaire')->findBy(array());
        $reactions=$em->getRepository('PublicationBundle:reaction')->findBy(array());
       return $this->render('@Publication/Posts/edit-post.html.twig',array('editform'=>$editform->createView(),'post'=>$post,'comments'=>$comments,'reactions'=>$reactions));


    }
    /**
     * Creates a form to delete a publication entity.
     *
     * @param Post $post
     *
     * @return Form|\Symfony\Component\Form\FormInterface
     */
    private function createDeleteForm(Post $post)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('publication_delete', array('id' => $post->getId())))
            ->setMethod('DELETE')
            ->getForm();
    }
    public function affichagePostAction()
    {
        $User = $this->getUser();
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository('PublicationBundle:Post')->findBy(array(), array('date'=>'DESC'));
        return $this->redirectToRoute('publication_homepage');
    }
    public function VoteAction($id_post,Request $request,$slug )
    {
        $user = $this->getUser() ;

        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository('PublicationBundle:Post')->find($id_post);
        $vote = $em->getRepository('PublicationBundle:Vote')->findOneBy(array('post'=>$id_post, 'idUser'=>$user->getId()));

        if ($post && !$vote ) {
            $vote = new Vote();
            $vote->setPost($post);
            $vote->setIdUser($user);
            $vote->setDate(new \DateTime("now", new \DateTimeZone('+0100')));
            $vote->setValeur($slug);
            $em->persist($vote);
            $em->flush();
            $post->setVotesPost($post->getVotespost($id_post) + $slug);
            $em->flush();

        }

        elseif($post&&$vote)
        {
            if($vote->getValeur()==$slug)
            {
                $em->remove($vote);
                $em->flush();
                $post->setVotesPost($post->getVotespost($id_post) - $slug);
                $em->flush();
            }
            else
            {
                $vote->setValeur($slug);
                $em->persist($vote);
                $em->flush();
                $post->setVotesPost($post->getVotespost($id_post) + $slug);
                $em->flush();
            }
        }

        return $this->redirectToRoute("publication_homepage");
    }
public function ReactAction($id_post,Request $request,$type)
{
    $user = $this->getUser() ;

    $em = $this->getDoctrine()->getManager();
    $post = $em->getRepository('PublicationBundle:Post')->find($id_post);
    $react= $em->getRepository('PublicationBundle:reaction')->findOneBy(array('post'=>$id_post, 'idUser'=>$user->getId()));
    if ($post && !$react ) {
        $react = new reaction();
        $react->setPost($post);
        $react->setIdUser($user);
        $react->setDate(new \DateTime("now", new \DateTimeZone('+0100')));
        $react->setType($type);
        $em->persist($react);
        $em->flush();
        $post->setReactionPost($post->getReactionPost($id_post) + 1);
        $em->flush();
    }

    elseif($post&&$react)
    {
        if($react->getType()==$type)
        {
            $em->remove($react);
            $em->flush();
            $post->setReactionPost($post->getReactionPost($id_post) - 1);
            $em->flush();
        }
        else
        {
            $react->setType($type);
            $em->persist($react);
            $em->flush();
            $post->setReactionPost($post->getReactionPost($id_post));
            $em->flush();
        }
    }

    return $this->redirectToRoute("publication_homepage");
}

}
