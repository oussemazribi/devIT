<?php

namespace BlogBundle\Form;

use FOS\CKEditorBundle\Form\Type\CKEditorType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
class PostType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('sujet',TextType::class, array('required' => true))
            ->add('contenu',CKEditorType::class)
            ->add('dateCreation',DateTimeType::class,['widget' => 'single_text','attr' => ['class' => 'js-datepicker']])

         //->add('photo',VichImageType::class, array('attr' => array('class' => 'form-control'),'label' => "Image"))
         ->add('file', FileType::class, array('attr' => array('class' => 'form-control')))
            ->add('Ajouter', SubmitType::class, array('label' => 'Ajouter', 'attr' => array('class' => 'btn btn-success ','style'=>'margin-top:10px'  )));
    }

    /**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'BlogBundle\Entity\Post'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'blogbundle_post';
    }


}
