<?php

namespace CompetitionBundle\Controller;
use CompetitionBundle\Entity\Competition;
use CompetitionBundle\Entity\Participation;
use CompetitionBundle\Entity\Ticket;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class ParticipationController extends Controller
{


    public function affichParAction(){
        $em=$this->getDoctrine()->getManager();
        $Participation=$em->getRepository("CompetitionBundle:Participation")->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Participation);
        return new JsonResponse($formatted);
    }

    public function newAction(Request $request)
    {

        $em = $this->getDoctrine()->getManager();


        $Participation = new Participation();

        $user=$em->getRepository("FOSBundle:User")->find($request->get('user'));
        $Participation->setIduser($user);
        $Competition=$em->getRepository("CompetitionBundle:Competition")->find($request->get('competition'));
        $Participation->setIdcompetition($Competition);




        $em->persist($Participation);
        $em->flush();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Participation);
        return new JsonResponse($formatted);
    }


    public function supprimerPmobileAction($id,$id1)
    {
        $em = $this->getDoctrine()->getManager();

        $Participation=$em->getRepository("CompetitionBundle:Participation")->findOneBy(array('iduser'=>$id,'idcompetition'=>$id1));

        $em->remove($Participation);
        $em->flush();
        //return $this->redirectToRoute('affichercompetition');
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($id);
        return new JsonResponse($formatted);
    }

    public function mobileAction($id,$id1)
    {
        $em = $this->getDoctrine()->getManager();
        $Competition=$em->getRepository("CompetitionBundle:Competition")->findOneBy(array('idcompetition'=>$id1));
        $user=$em->getRepository("FOSBundle:User")->findOneBy(array('id'=>$id));
        $user->setNbdiament($user->getNbdiament()-$Competition->getCout());

        $em->persist($user);
        $em->flush();
        //return $this->redirectToRoute('affichercompetition');
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($user);
        return new JsonResponse($formatted);
    }

    public function FindParAction($id,$id1)
    {

        $data = [
            'type' => 'Participation  Not Found',
            'title' => 'There was a validation error',
            'errors' => 'username or password invalide'
        ];
        $response = new JsonResponse($data, 400);

        $em = $this->getDoctrine()->getManager();

        $Participation=$em->getRepository("CompetitionBundle:Participation")->findOneBy(array('iduser'=>$id,'idcompetition'=>$id1));



        if($Participation)
        {
            $data=array('type'=>'Participation Found',
                'title'=>'yes',
                'errors'=>'no errors',
            );
            $response = new JsonResponse($data, 200);
            return $response;

        }

        else
        {
            return $response;

        }
    }



    public function ajouterParticipationAction(Request $request , $id,$type)
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
        // $message = new \DocDocDoc\NexmoBundle\Message\Simple("Tunisian GT", "21623422387", "Participation avec succée je vous souhaite la bienvenue  :) ");
        // $nexmoResponse = $this->container->get('doc_doc_doc_nexmo')->send($message);
        return $this->redirectToRoute('ajouterticket', array(
            'id' => $id,
            'type'=>$type,


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
