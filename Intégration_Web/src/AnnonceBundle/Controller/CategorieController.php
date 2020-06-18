<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Categorie;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\CategorieType;

class CategorieController extends Controller
{

    public function ajouterCatAction(Request $request){
        $Categorie = new Categorie();



        $form = $this->createForm(CategorieType::class, $Categorie);
        $form->add('imagec', FileType::class, [

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
        $em = $this->getDoctrine()->getManager();

        $Cat=$em->getRepository("AnnonceBundle:Categorie")->findAll();

        if ($form->isSubmitted() && $form->isValid()) {



            $srcFile = $form->get('imagec')->getData();
            if ($srcFile) {
                $originalFilename = pathinfo($srcFile->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$srcFile->guessExtension();

                try {
                    $srcFile->move('uploads/' . $Categorie->getImagec(), $newFilename);
                } catch (FileException $e) {
                    print $e->getMessage();
                }
                $Categorie->setImagec($newFilename);

            }



            $em->persist($Categorie);
            $em->flush();





            return $this->redirectToRoute('CatAdmin');
        }


        return $this->render('@Annonce/Annonce/CategorieAdmin.html.twig', array(

            'form' => $form->createView(),
            'Cat'=>$Cat,

        ));

    }




}
