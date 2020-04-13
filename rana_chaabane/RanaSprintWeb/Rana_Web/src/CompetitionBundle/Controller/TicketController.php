<?php

namespace CompetitionBundle\Controller;


use CompetitionBundle\Entity\Competition;
use CompetitionBundle\Entity\Ticket;
use CompetitionBundle\Form\CompetitionType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;



class TicketController extends Controller
{

    public function ajouterTicketAction(Request $request , $id)
    {

        $Ticket = new Ticket();
        $Ticket->setDateemission(new \DateTime('now'));
        $user = $this->getUser();

        $random = random_int(1000, 1000000);
        $Ticket->setMotDePasse($random);
        $Ticket->setIduser($user);





        $em = $this->getDoctrine()->getManager();
        $idc=$em->getRepository('CompetitionBundle:Competition')->find($id);
        $Ticket->setIdcompetition($idc);
        $em->persist($Ticket);
        $em->flush();
        return $this->redirectToRoute('Ticket', array(
            'id' => $id,

        ));

        //  return $this->redirectToRoute('evenement_show', array('id_evenement' => $evenement->getId_evenement()));



    }

    public function afficherTicketAction(Request $request , $id){
        $em=$this->getDoctrine()->getManager();
        $comp=$em->getRepository("CompetitionBundle:Competition")->findBy(array('idcompetition'=>$id));
        $Ticket=$em->getRepository("CompetitionBundle:Ticket")->findBy(array('idcompetition'=>$id));
        $users=$em->getRepository("FOSBundle:User")->findAll();



        $user = $this->getUser();
        foreach ($comp as $c)
        {
            foreach ($users as $u)
            {
                $participations = $em->getRepository('CompetitionBundle:Participation')->findBy(array('idcompetition' => $c->getIdcompetition(),'iduser' => $u->getId()));

            }

        }

        return $this->render('@Competition/Competition/Ticket.html.twig',
            array('Ticket'=>$Ticket,
                'comp'=>$comp,
                'Participation'=>$participations,

            ));
    }

    public function supprimerTicketAction($id,$id1)
    {
        $em = $this->getDoctrine()->getManager();

        $Ticket = $em->getRepository("CompetitionBundle:Ticket")->findOneBy(array('idcompetition'=>$id,'iduser'=>$id1));
        $em->remove($Ticket);
        $em->flush();
        return $this->redirectToRoute('affichercompetitionUser');
    }



}
