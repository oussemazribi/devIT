<?php

namespace CompetitionBundle\Controller;

use CompetitionBundle\Entity\Competition;
use CompetitionBundle\Form\CompetitionType;
use evenementBundle\Form\evenementType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Mgilet\NotificationBundle\Annotation\Notifiable;
use Mgilet\NotificationBundle\NotifiableInterface;


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
        $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();

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
            'Participation'=>$Participation,
        ));

    }

    public function afficherCompetitionAction(){
        $em=$this->getDoctrine()->getManager();
        $Competition=$em->getRepository("CompetitionBundle:Competition")->findAll();

         $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();

        $users=$em->getRepository("FOSBundle:User")->findAll();
        $now=(new \DateTime('now'));
        $Trending=$em->getRepository("CompetitionBundle:Competition")->findBy(array('datedebut'=>$now), array('datedebut'=>'DESC'), 3);
        return $this->render('@Competition/Competition/afficherCompetition.html.twig',
            array('Competition'=>$Competition,
                'Participation'=>$Participation,
                'users'=>$users,
                'Trending'=>$Trending,
                'now'=>$now,
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
        $Ticket =$em->getRepository("CompetitionBundle:Ticket")->findBy(array('iduser'=>$user->getId()));
        $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();


        foreach ($Competition as $evt) {

            $participations = $em->getRepository('CompetitionBundle:Participation')->findBy(array('idcompetition' => $evt->getIdcompetition(),'iduser' => $user->getId()));


            if ((count($participations) > 0) ) {
                $evt->setParticipe(true);
            } else {
                $evt->setParticipe(false);
            }


}
        $now=(new \DateTime('now'));
        $Trending=$em->getRepository("CompetitionBundle:Competition")->findBy(array('datedebut'=>$now), array('datedebut'=>'DESC'), 3);

        return $this->render('@Competition/Competition/afficherCompetitionUser.html.twig',
            array('Competition'=>$Competition,
                'Trending'=>$Trending,
                'now'=>$now,
                'Ticket'=>$Ticket,
                'Participation'=>$Participation,
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


    public function afficherTrendingCompetitionAction(){
        $em=$this->getDoctrine()->getManager();
        $now=(new \DateTime('now'));
        $user=$this->getUser();
        $Trending=$em->getRepository("CompetitionBundle:Competition")->findBy(array('datedebut'=>$now), array('datedebut'=>'DESC'), 3);

        foreach ($Trending as $evt) {

            $participations = $em->getRepository('CompetitionBundle:Participation')->findBy(array('idcompetition' => $evt->getIdcompetition(), 'iduser' => $user->getId()));


            if ((count($participations) > 0)) {
                $evt->setParticipe(true);
            } else {
                $evt->setParticipe(false);
            }
        }



        return $this->render('@Competition/Competition/afficherCompetitionAdmin.html.twig',
            array('Trending'=>$Trending,
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
        $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();


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
            'Participation'=>$Participation,
        ));
    }

    public function detailuserAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $Competition = $em->getRepository('CompetitionBundle:Competition')->find($id);
        $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();



        return $this->render('@Competition/Competition/detailComp.html.twig', array(
            'Competition' => $Competition,
            'Participation'=>$Participation,

            ));
    }





    public function searchAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $requestString = $request->get('q');
        $competition = $em->getRepository('CompetitionBundle:Competition')->findEntitiesByString($requestString);
        if (!$competition) {
            $result['Competition']['error'] = "Competition Not found :( ";
        } else {
            $result['Competition'] = $this->getRealEntities($competition);
        }
        return new Response(json_encode($result));
    }

    public function getRealEntities($competition)
    {
        foreach ($competition as $competition) {
            $realEntities[$competition->getIdcompetition()] = [$competition->getImagec(), $competition->getTitre()];

        }
        return $realEntities;
    }


}
