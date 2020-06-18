<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categorie
 *
 * @ORM\Table(name="categorie")
 * @ORM\Entity(repositoryClass="AnnonceBundle\Repository\CategorieRepository")
 */
class Categorie
{

    // ...

    /**
     * @ORM\OneToMany(targetEntity="Annonce", mappedBy="Categorie")
     */
    private $Annonce;


    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255)
     */
    private $nom;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Categorie
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @var string
     *
     * @ORM\Column(name="imagec", type="string", length=255, nullable=false)
     */
    private $imagec;

    /**
     * @return string
     */
    public function getImagec()
    {
        return $this->imagec;
    }

    /**
     * @param string $imagec
     */
    public function setImagec($imagec)
    {
        $this->imagec = $imagec;
    }


}

