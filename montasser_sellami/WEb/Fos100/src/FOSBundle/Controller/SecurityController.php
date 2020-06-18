<?php

namespace FOSBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class SecurityController extends Controller
{
    public function redirectAction()
    {
        $user=$this->getUser();
        if($user)
        {
            if(!($user->isSuperAdmin()))
            {

                if ($user->getTypecompte()=='Administrateur')
                    return $this->redirectToRoute('blog_ajoutBlog');
                else if ($user->getTypecompte()=='Simple Utilisateur')
                {
                    return $this->redirectToRoute('blog_afficheBlogUser');
                }
            }
            else
            {
                return $this->redirectToRoute('blog_ajoutBlog');
            }


        }



        return $this->redirectToRoute('fos_user_security_login');
    }

}
