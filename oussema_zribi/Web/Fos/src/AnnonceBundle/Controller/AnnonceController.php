<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Annonce;
use AnnonceBundle\Form\AnnonceType;
use Symfony\Component\HttpFoundation\Request;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class AnnonceController extends Controller
{
    public function ajouterAnnonceAction(Request $request){
        $Annonc= new Annonce();
        $user = $this->getUser();
        $Annonc->setUser($user);
        $form=$this->createForm(AnnonceType::class,$Annonc);
        $form->handleRequest($request);
        $em=$this->getDoctrine()->getManager();
        if($form->isSubmitted()){


            $em->persist($Annonc);
            $em->flush();
            return $this->redirectToRoute('afficherannonce');
        }


        return $this->render('@Annonce/Annonce/ajouterAnnonce.html.twig',
            array('form'=>$form->createView()));
    }
    public function afficherAnnonceAction(){
        $em=$this->getDoctrine()->getManager();
        $Ann=$em->getRepository("AnnonceBundle:Annonce")->findAll();
        $users=$em->getRepository("FOSBundle:User")->findAll();
        return $this->render('@Annonce/Annonce/afficherAnnonce.html.twig',
            array('Annonce'=>$Ann, 'users'=>$users));

    }

    public function detailAnnonceAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $ann = $em->getRepository('AnnonceBundle:Annonce')->find($id);


        return $this->render('@Annonce/Annonce/detailAnnonce.html.twig', array(
            'Annonce' => $ann,

        ));
    }


    function RechercheAction(Request $request){
        $Annonce=new Annonce();

        $Form=$this->createFormBuilder($Annonce)
            ->add('nom')
            ->add('Rechercher',SubmitType::class)
            ->getForm();
        $Form->handleRequest($request);
        if($Form->isSubmitted()){
            $Annonce=$this->getDoctrine()
                ->getRepository(Annonce::class)
                ->findBy(array('nom'=>$Annonce->getNom()));
        }
        else{
            $Annonce=$this->getDoctrine()
                ->getRepository(Annonce::class)
                ->findAll();
        }

        return $this->render('@Annonce/Annonce/afficherAnnonce.html.twig',
            array('f'=>$Form->createView(),'Annonce'=>$Annonce ));

    }
    function SupprimerAction($id){
        $em=$this->getDoctrine()->getManager();
        $ann=$this->getDoctrine()->getRepository(Annonce::class)
            ->find($id);
        $em->remove($ann);
        $em->flush();
        return $this->redirectToRoute('afficherannonce');
    }
    public function  ModifierAction(Request $request, $id){
        $em=$this->getDoctrine()->getManager();
        $ann=$this->getDoctrine()
            ->getRepository(Annonce::class)
            ->find($id);
        $form=$this->createForm(AnnonceType::class,$ann);
        $form->handleRequest($request);
        if($form->isSubmitted() ){
            $em->flush();
            return $this->redirectToRoute('afficherannonce');

        }
        return $this->render('@Annonce/Annonce/modifierAnnonce.html.twig',
            array('form'=>$form->createView()));
    }


}
