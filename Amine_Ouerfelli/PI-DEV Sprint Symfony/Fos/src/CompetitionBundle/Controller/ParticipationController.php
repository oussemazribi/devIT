<?php

namespace CompetitionBundle\Controller;
use CompetitionBundle\Entity\Participation;
use CompetitionBundle\Entity\Ticket;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ParticipationController extends Controller
{

    public function ajouterParticipationAction(Request $request , $id)
    {

        $Participation = new Participation();
        $user = $this->getUser();
        $em = $this->getDoctrine()->getManager();
        $idc=$em->getRepository('CompetitionBundle:Competition')->find($id);
        $comp=$em->getRepository('CompetitionBundle:Competition')->findBy(array('idcompetition'=>$id));
        foreach ($comp as $c)
        {
            $user->setNbdiament($user->getNbdiament()-$c->getCout());

        }
        #$idu=$em->getRepository('FOSBundle:User')->find($id1);
        $Participation->setIdcompetition($idc);
        $Participation->setIduser($user);

        $em->persist($Participation);
        $em->flush();
        return $this->redirectToRoute('ajouterticket', array(
            'id' => $id,


        ));
        //  return $this->redirectToRoute('evenement_show', array('id_evenement' => $evenement->getId_evenement()));



    }


    public function supprimerParticipationAction($id,$id1)
    {
        $em = $this->getDoctrine()->getManager();

        $Participation = $em->getRepository("CompetitionBundle:Participation")->findOneBy(array('idcompetition'=>$id,'iduser'=>$id1));
        $em->remove($Participation);
        $em->flush();
        return $this->redirectToRoute('supprimerticket', array(
            'id' => $id,
            'id1'=>$id1,
        ));
    }


}
