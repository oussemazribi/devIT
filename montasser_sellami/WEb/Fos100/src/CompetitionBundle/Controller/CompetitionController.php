<?php

namespace CompetitionBundle\Controller;

use CompetitionBundle\Entity\Competition;
use CompetitionBundle\Form\CompetitionType;
use evenementBundle\Form\evenementType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;


class CompetitionController extends Controller
{
    public function ajoutercompetitionAction(Request $request)
    {

        $Competition = new Competition();
        $user = $this->getUser();

        #$Competition->setIduser( $user->getId());
        $form = $this->createForm(CompetitionType::class, $Competition);
        $form->handleRequest($request);
        $em = $this->getDoctrine()->getManager();
        #affichage de TOP 3 #
        #$louay = $em->getRepository('CompetitionBundle:Competition')->findBy(array(), array('cout'=>'DESC'), 3);#
        #$louay = $em->getRepository('CompetitionBundle:Competition')->findAll();#
        $louay = $em->getRepository('CompetitionBundle:Competition')->findBy(array('iduser' => $user->getId()));

        if ($form->isSubmitted() && $form->isValid()) {




            $Competition->setIduser($user);
            $Competition->upload();

            $em->persist($Competition);
            $em->flush();

            //  return $this->redirectToRoute('evenement_show', array('id_evenement' => $evenement->getId_evenement()));
            $this->get('session')->getFlashBag()->add('succes'," Ajout d'une nouvelle Competition avec succées !!!");
            return $this->redirectToRoute('affichercompetition');
        }


        return $this->render('@Competition/Competition/ajouterCompetition.html.twig', array(
            'Competition'=>$Competition,
            'form' => $form->createView(),
            'louay'=>$louay,
        ));

    }

    public function afficherCompetitionAction(){
        $em=$this->getDoctrine()->getManager();
        $Competition=$em->getRepository("CompetitionBundle:Competition")->findAll();

         $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();





        $users=$em->getRepository("FOSBundle:User")->findAll();


        return $this->render('@Competition/Competition/afficherCompetition.html.twig',
            array('Competition'=>$Competition,
                'Participation'=>$Participation,
                'users'=>$users,
            ));

    }

    public function afficherCompAction(){
        $em=$this->getDoctrine()->getManager();
        $louay=$em->getRepository("CompetitionBundle:Competition")->findAll();
        return $this->render('@Competition/Competition/ajouterCompetition.html.twig',
            array('louay'=>$louay));

    }

    public function afficherCompetitionUserAction(){
        $em=$this->getDoctrine()->getManager();
        $Competition=$em->getRepository("CompetitionBundle:Competition")->findAll();
        $user = $this->getUser();

        foreach ($Competition as $evt) {

            $participations = $em->getRepository('CompetitionBundle:Participation')->findBy(array('idcompetition' => $evt->getIdcompetition(),'iduser' => $user->getId()));


            if ((count($participations) > 0) ) {
                $evt->setParticipe(true);
            } else {
                $evt->setParticipe(false);
            }

}
        return $this->render('@Competition/Competition/afficherCompetitionUser.html.twig',
            array('Competition'=>$Competition,



            ));
    }

    public function afficherCompetitionAdminAction(){
        $em=$this->getDoctrine()->getManager();
        $Competition=$em->getRepository("CompetitionBundle:Competition")->findAll();
        $louay = $em->getRepository('CompetitionBundle:Competition')->findBy(array(), array('datedebut'=>'DESC'), 3);




        return $this->render('@Competition/Competition/afficherCompetitionAdmin.html.twig',
            array('Competition'=>$Competition,
                'louay'=>$louay



            ));
    }


    public function supprimerCompetitionAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $Competition = $em->getRepository("CompetitionBundle:Competition")->find($id);
        $em->remove($Competition);
        $em->flush();
        return $this->redirectToRoute('affichercompetition');
    }

    public function supprimerCompetitionAdminAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $Competition = $em->getRepository("CompetitionBundle:Competition")->find($id);
        $em->remove($Competition);
        $em->flush();
        return $this->redirectToRoute('affichercompetitionAdmin');
    }

    public function modifiercompetitionAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $user=$this->getUser();
        $Competition = $em->getRepository("CompetitionBundle:Competition")->find($id);
        $form = $this->createForm(CompetitionType::class, $Competition);
        $louay = $em->getRepository('CompetitionBundle:Competition')->findBy(array('iduser' => $user->getId()));

        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $Competition->upload();
            $em->persist($Competition);
            $em->flush();
            return $this->redirectToRoute('affichercompetition');
        }
        return $this->render('@Competition/Competition/modifierCompetition.html.twig', array(
            'form' => $form->createView(),
            'louay'=> $louay,
        ));
    }

    public function detailuserAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $Competition = $em->getRepository('CompetitionBundle:Competition')->find($id);


        return $this->render('@Competition/Competition/detailComp.html.twig', array(
            'Competition' => $Competition,

            ));
    }

}
