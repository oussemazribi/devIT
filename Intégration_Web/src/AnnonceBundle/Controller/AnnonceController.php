<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Annonce;
use AnnonceBundle\Entity\Categorie;
use AnnonceBundle\Form\AnnonceType;
use FOSBundle\Entity\User;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;


use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;


class AnnonceController extends Controller
{
    public function ajouterAnnonceAction(Request $request){
        $Annonc= new Annonce();
        $user = $this->getUser();
        $Annonc->setUser($user);
        $Annonc->setDateCreation(new \DateTime('now'));
        $form=$this->createForm(AnnonceType::class,$Annonc);

        $form->add('images', FileType::class, [

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
        $em=$this->getDoctrine()->getManager();
        if ($form->isSubmitted() && $form->isValid()) {



            $srcFile = $form->get('images')->getData();
            if ($srcFile) {
                $originalFilename = pathinfo($srcFile->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$srcFile->guessExtension();

                try {
                    $srcFile->move('uploads/' . $Annonc->getImages(), $newFilename);
                } catch (FileException $e) {
                    print $e->getMessage();
                }
                $Annonc->setImages($newFilename);

            }

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
        $Cat=$em->getRepository("AnnonceBundle:Categorie")->findAll();
        $users=$em->getRepository("FOSBundle:User")->findAll();
        return $this->render('@Annonce/Annonce/afficherAnnonce.html.twig',
            array('Annonce'=>$Ann,
                'Cat'=>$Cat,
                'users'=>$users));

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
public function addAnnonceAction( $iduser , $idcat , $nom , $description  , $prix,$images  ){
    $em=$this->getDoctrine()->getManager();
    $annonce = new Annonce();
    $annonce->setNom($nom);
    $annonce->setPrix($prix);
    $annonce->setDateCreation(new \DateTime('now'));
    $annonce->setCategorie($em->getRepository(Categorie::class)->find($idcat));
    $annonce->setUser($em->getRepository(User::class)->find($iduser));
    $annonce->setDescription($description);
    $annonce->setEtat('Disponible');
    $annonce->setImages($images);
    $em->persist($annonce);
    $em->flush();
    return new JsonResponse(200);
}
public function displayAnnonceAction(){
    $em=$this->getDoctrine()->getManager();
    $annonces = $em->getRepository(Annonce::class)->findAll();
    $serializer = new Serializer([new ObjectNormalizer()]);//serializer pour renvoyer les données json bi symfony
    $formatted = $serializer->normalize($annonces);// transformer les objets en Arrays a travers normalize
    return new JsonResponse($formatted);// jsonResponse prend en paramettre $formatted eli houwa Arraya

}
public function getAnnonceByCatAction($id ){
    $em=$this->getDoctrine()->getManager();
    $categorie = $em->getRepository(Categorie::class)->find($id);
    $annonces = $em->getRepository(Annonce::class)->findByCategorie($categorie);
    $serializer = new Serializer([new ObjectNormalizer()]);//serializer pour renvoyer les données json bi symfony
    $formatted = $serializer->normalize($annonces);// transformer les objets en Arrays a travers normalize
    return new JsonResponse($formatted);// jsonResponse prend en paramettre $formatted eli houwa Arraya

}
public function  deleteAnnonceAction($id){
    $em=$this->getDoctrine()->getManager();
$annonce = $em->getRepository(Annonce::class)->find($id);
$em->remove($annonce);
$em->flush();
return new JsonResponse(200);
}
public function updateAnnonceAction($id , $idcat , $nom , $description  , $prix , $images ){
    $em=$this->getDoctrine()->getManager();
    $annonce = $em->getRepository(Annonce::class)->find($id);
    $annonce->setNom($nom);
    $annonce->setPrix($prix);
    $annonce->setDateCreation(new \DateTime('now'));
    $annonce->setCategorie($em->getRepository(Categorie::class)->find($idcat));
    $annonce->setDescription($description);
    $annonce->setEtat('Disponible');
    $annonce->setImages($images);
    $em->persist($annonce);
    $em->flush();
    return new JsonResponse(200);
}
    public function getCategoriesAction(){
    $em=$this->getDoctrine()->getManager();
    $categories = $em->getRepository(Categorie::class)->findAll();
    $serializer = new Serializer([new ObjectNormalizer()]);//serializer pour renvoyer les données json bi symfony
    $formatted = $serializer->normalize($categories);// transformer les objets en Arrays a travers normalize
    return new JsonResponse($formatted);
}



}
