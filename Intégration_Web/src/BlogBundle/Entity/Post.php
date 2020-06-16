<?php

namespace BlogBundle\Entity;

use BlogBundle\Entity\Comment;
use Doctrine\ORM\Mapping as ORM;
use FOSBundle\Entity\User;



use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\HttpFoundation\File\UploadedFile;

/**
 * Post
 *
 * @ORM\Table(name="Article")
 * @ORM\Entity(repositoryClass="BlogBundle\Repository\PostRepository")
 */
class Post
{
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
     * @ORM\Column(name="sujet", type="string", length=255)
     */
    private $sujet;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu", type="string", length=255)
     */
    private $contenu;
    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateCreation", type="date")
     */
    private $dateCreation;

    /**
     * @var string
     *
     * @ORM\Column(name="photo", type="string", length=250, nullable=true)
     */
    public $photo;


    /**
     * @Assert\File(maxSize="500k")
     */
    public $file;

    /**
     * @ORM\OneToMany(targetEntity="Comment", mappedBy="blog")
     */
    private $comments;



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
     * Set sujet
     *
     * @param string $sujet
     *
     * @return Post
     */
    public function setSujet($sujet)
    {
        $this->sujet = $sujet;

        return $this;
    }

    /**
     * Get sujet
     *
     * @return string
     */
    public function getSujet()
    {
        return $this->sujet;
    }

    /**
     * Set contenu
     *
     * @param string $contenu
     *
     * @return Post
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;

        return $this;
    }

    /**
     * Get contenu
     *
     * @return string
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * Set dateCreation
     *
     * @param \DateTime $dateCreation
     *
     * @return Post
     */
    public function setDateCreation($dateCreation)
    {
        $this->dateCreation = $dateCreation;

        return $this;
    }

    /**
     * Get dateCreation
     *
     * @return \DateTime
     */
    public function getDateCreation()
    {
        return $this->dateCreation;
    }



    public function getWebpath(){
        return null===$this->photo ? null : $this->getUploadDir().'/'.$this->photo;
    }

    protected function getUploadRootDir(){
        return __DIR__.'/../../../web/'.$this->getUploadDir();
    }

    protected function getUploadDir(){
        return 'images';
    }

    public function uploadProfilePicture(){
        $this->file->move($this->getUploadRootDir(), $this->file->getClientOriginalName());
        $this->photo=$this->file->getClientOriginalName();
        $this->file=null;
    }

    /**
     * Set photo
     *
     * @param string $photo
     *
     * @return Post
     */
    public function setPhoto($photo)
    {
        $this->photo = $photo;

        return $this;
    }

    /**
     * Get photo
     *
     * @return string
     */
    public function getPhoto()
    {
        return $this->photo;
    }



    /**
     * @return mixed
     */
    public function getComments()
    {
        return $this->comments;
    }

    /**
     * @param mixed $comments
     */
    public function setComments($comments)
    {
        $this->comments = $comments;
    }
    public function removeComment(Comment $comment)
    {
        $this->comments->removeElement($comment);
    }
    public function addComment(Comment $comment)
    {
        $this->comments[] = $comment;

        return $this;
    }
    public function __construct()
    {
        $this->comments = new \Doctrine\Common\Collections\ArrayCollection();
    }
}

