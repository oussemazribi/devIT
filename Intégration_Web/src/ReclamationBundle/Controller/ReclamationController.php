<?php

namespace ReclamationBundle\Controller;

use ReclamationBundle\Entity\Reclamation;
use ReclamationBundle\Form\ReclamationType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class ReclamationController extends Controller
{
    public function allAction()
    {
        $tasks = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);
    }

    public function findAction($id)
    {
        $tasks = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->find($id);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);
    }

    public function newAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $task = new Reclamation();
        $src = $request->files->get('file');
        if ($src) {
            $originalFilename = pathinfo($src->getClientOriginalName(), PATHINFO_FILENAME);
            $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
            $newFilename = $safeFilename . '-' . uniqid() . '.' . $src->guessExtension();

            try {
                $src->move('uploads/' . 'Reclamation', $newFilename);
            } catch (FileException $e) {
                print $e->getMessage();
            }
            $task->setObjet($request->get('objet'));
            $task->setDescription($request->get('description'));
            $task->setPhoto($newFilename);
            $task->setDateReclamation(new \DateTime("now", new \DateTimeZone('+0100')));
            $task->setStatut($request->get('etat'));
            $em->persist($task);
            $em->flush();
            return new Response("coll");

        }


    }
    public function traiterAction(Request $req,$id)
    {   $em=$this->getDoctrine()->getManager();
        $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
        if($rec!=null)
        {
            $rec->setStatut("traité");
            $em->persist($rec);
            $em->flush();
        }
        return new Response("cbon");
    }
    public function supprimerAction(Request $req,$id)
    {
        {   $em=$this->getDoctrine()->getManager();
            $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
            if($rec!=null)
            {

                $em->remove($rec);
                $em->flush();
            }
            return new Response("supp");

        }
    }
    public function AjouterreclamationAction(Request $request)
    {   $user=$this->getUser();
        $em = $this->getDoctrine()->getManager();
        $Rec = new Reclamation();
        $Rec->setDateReclamation(new \DateTime("now", new \DateTimeZone('+0100')));
        $Rec->setStatut('non Traitée');
        $Rec->setIduser($user);
        $form = $this->createForm(ReclamationType::class, $Rec);
        $form->add('photo', FileType::class, [
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

        $form->handleRequest($request);
        if($form->isValid()&&$form->isSubmitted())
        {   $src = $form->get('photo')->getData();
            if ($src) {
                $originalFilename = pathinfo($src->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                $newFilename = $safeFilename . '-' . uniqid() . '.' . $src->guessExtension();

                try {
                    $src->move('uploads/' . 'Reclamation', $newFilename);
                } catch (FileException $e) {
                    print $e->getMessage();
                }
                $Rec->setPhoto($newFilename);
            }
            $em->persist($Rec);
            $em->flush();
            $Reclamations = $this->getDoctrine()->getManager()
                ->getRepository('ReclamationBundle:Reclamation')
                ->findBy(array('iduser' => $user->getId()));
            return $this->render('@Reclamation/AjoutReclamation.html.twig',array('form'=>$form->createView(),'user'=>$user,'Reclamations'=>$Reclamations));
        }
        $Reclamations = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->findBy(array('iduser' => $user->getId()));
        return $this->render('@Reclamation/AjoutReclamation.html.twig',array('form'=>$form->createView(),'user'=>$user,'Reclamations'=>$Reclamations));
    }

    public function DeleteReclamationAction(Request $req,$id)
    {
            $user=$this->getUser();
            $em=$this->getDoctrine()->getManager();
            $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
            if($rec!=null)
            {
                $em->remove($rec);
                $em->flush();
            }
            return $this->redirectToRoute('Affichage_Reclamation');
    }
    public function AffichierreclamtionsAction()
    {   $user=$this->getUser();
        $Reclamations = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->findAll();
        return $this->render('@Reclamation/pagereclamationcoteadmin.html.twig',array('Reclamations'=>$Reclamations));
    }
    public function TraiterReclamtionsAction(Request $req,$id)
    {   $em=$this->getDoctrine()->getManager();
        $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
        if($rec!=null)
        {
            $rec->setStatut("traité");
            $em->persist($rec);
            $em->flush();
        }
        return $this->redirectToRoute('Affichage_Reclamation');
    }
    public function findReclamtionAction($id)
    {
        $reclamation = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->find($id);
        return $this->render('@ReclamationBundle/Default/showonereclamation',array('reclamation'=>$reclamation));
    }
    public function ModifierReclamtionAction(Request $req,$id)
    {   $user=$this->getUser();
        $em=$this->getDoctrine()->getManager();
        $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
        $formmodif=$this->createForm(ReclamationType::class,$rec);
        $formmodif->add('photo', FileType::class, [
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
        if($rec!=null&&$user)
        {
            if($formmodif->isValid()&&$formmodif->isSubmitted())
            {   $src = $formmodif->get('photo')->getData();
                if ($src) {
                    $originalFilename = pathinfo($src->getClientOriginalName(), PATHINFO_FILENAME);
                    $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                    $newFilename = $safeFilename . '-' . uniqid() . '.' . $src->guessExtension();

                    try {
                        $src->move('uploads/' . 'Reclamation', $newFilename);
                    } catch (FileException $e) {
                        print $e->getMessage();
                    }
                    $rec->setPhoto($newFilename);
                }
                $em->persist($rec);
                $em->flush();
                return $this->redirectToRoute('Affichage_client') ;
            }

        }
        return $this->render('@Reclamation/Default/ModifierReclamationCoteclient.html.twig',array('formmodif'=>$formmodif->createView(),'user'=>$user));
    }
    public function AffichierreclamtionsclientAction()
    {  $user=$this->getUser();
        $Reclamations = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->findBy(array('iduser' => $user->getId()));

        return $this->render('@Reclamation/pagereclamationcoteclient.html.twig',array('Reclamations'=>$Reclamations,'user'=>$user));
    }
    public function DeleteReclamationclientAction(Request $req,$id)
    {
            $user=$this->getUser();
            $em=$this->getDoctrine()->getManager();
            $rec=$em->getRepository('ReclamationBundle:Reclamation')->find($id);
            if($rec!=null)
            {
                $em->remove($rec);
                $em->flush();
            }
            return $this->redirectToRoute('Affichage_client');
    }
    public function showoneclientAction(Request $req,$id)
    {
        $reclamation = $this->getDoctrine()->getManager()
            ->getRepository('ReclamationBundle:Reclamation')
            ->find($id);
        return $this->render('@Reclamation/Default/showonereclamation',array('reclamation'=>$reclamation));

    }
}
