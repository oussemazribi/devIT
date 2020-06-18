<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class DefaultController extends Controller
{
    /**
     * @Route("/", name="homepage")
     */
    public function indexAction(Request $request)
    {
        // replace this example code with whatever you need
        return $this->render('default/index.html.twig', [
            'base_dir' => realpath($this->getParameter('kernel.project_dir')).DIRECTORY_SEPARATOR,
        ]);
    }

    public function loginMobileAction($username, $password)
    {
        $user_manager = $this->get('fos_user.user_manager');
        $factory = $this->get('security.encoder_factory');

        $data = [
            'type' => 'validation error',
            'title' => 'There was a validation error',
            'errors' => 'username or password invalide'
        ];
        $response = new JsonResponse($data, 400);


        $user = $user_manager->findUserByUsername($username);
        if(!$user)
            return $response;


        $encoder = $factory->getEncoder($user);

        $bool = ($encoder->isPasswordValid($user->getPassword(),$password,$user->getSalt())) ? "true" : "false";
        if($bool=="true")
        {
            $role= $user->getRoles();

            $data=array('type'=>'Login succeed',
                'id'=>$user->getId(),

                'username'=>$user->getUsername(),
                'email'=>$user->getEmail(),
                'imguser'=>$user->getImguser(),
                'nbdiament'=>$user->getNbdiament(),
                'typecompte'=>$user->getTypecompte());





            $response = new JsonResponse($data, 200);
            return $response;

        }
        else
        {
            return $response;

        }
        // return array('name' => $bool);
    }


    public function FindUserIdAction($id)
    {
        $user_manager = $this->get('fos_user.user_manager');
        $factory = $this->get('security.encoder_factory');

        $data = [
            'type' => 'validation error',
            'title' => 'There was a validation error',
            'errors' => 'username or password invalide'
        ];
        $response = new JsonResponse($data, 400);

        $em = $this->getDoctrine()->getManager();
        $user=$em->getRepository("FOSBundle:User")->find($id);

        if($user)
        {
            $role= $user->getRoles();

            $data=array('type'=>'Login succeed',
                'id'=>$user->getId(),

                'username'=>$user->getUsername(),
                'email'=>$user->getEmail(),
                'imguser'=>$user->getImguser(),
                'nbdiament'=>$user->getNbdiament(),
                'typecompte'=>$user->getTypecompte());





            $response = new JsonResponse($data, 200);
            return $response;

        }
        else
        {
            return $response;

        }
        // return array('name' => $bool);
    }


    public function AjoutUserAction(Request $request)
    {
        $factory = $this->get('security.encoder_factory');
        $user_manager = $this->get('fos_user.user_manager');
        $user = $user_manager->createUser();
        $user->setUsername($request->get('username'));
        $user->setTypeCompte($request->get('typecompte')) ;
        $user->setEmail($request->get('email'));
        $user->setImgUser($request->get('imguser'));
        $encoder = $factory->getEncoder($user);
        $password = $encoder->encodePassword($request->get('password'), $user->getSalt());
        $user->setPassword($password);
        $user_manager->updateUser($user);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($user);
        return new JsonResponse($formatted);
    }

    public function finduserAction($id)
    {
        $user_manager = $this->get('fos_user.user_manager');
        $factory = $this->get('security.encoder_factory');
        $data = [
            'type' => 'validation error',
            'title' => 'There was a validation error',
            'errors' => 'username or password invalide'
        ];
        $response = new JsonResponse($data, 400);
        $user = $user_manager->findUserBy(array('id'=>$id));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($user);
        return new JsonResponse($formatted);
    }
}
