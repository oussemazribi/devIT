<?php

namespace AnnonceBundle\Form;

use AnnonceBundle\Entity\Categorie;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;


use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Validator\Constraints\File;
class AnnonceType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('nom')
            ->add('description')
            ->add('prix')
            ->add('etat' , HiddenType::class, [
                'data' => 'Disponible',
            ])
            ->add('images',FileType::class, [
                'label' => 'Content(image)',
                'mapped' => false,
                'constraints' => [
                    new File([
                        'maxSize' => '1M'
                    ])
                ],
            ])
            ->add('categorie',EntityType::class,[
                'class' => Categorie::class,
                'choice_label' => function(Categorie $user) {
                    return sprintf('(%d) %s', $user->getId(), $user->getNom());
                }
            ])

            ->add('valider',SubmitType::class);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Annonce'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'annoncebundle_annonce';
    }


}
