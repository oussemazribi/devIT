<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class appDevDebugProjectContainerUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
{
    public function __construct(RequestContext $context)
    {
        $this->context = $context;
    }

    public function match($rawPathinfo)
    {
        $allow = [];
        $pathinfo = rawurldecode($rawPathinfo);
        $trimmedPathinfo = rtrim($pathinfo, '/');
        $context = $this->context;
        $request = $this->request ?: $this->createRequest($pathinfo);
        $requestMethod = $canonicalMethod = $context->getMethod();

        if ('HEAD' === $requestMethod) {
            $canonicalMethod = 'GET';
        }

        if (0 === strpos($pathinfo, '/_')) {
            // _wdt
            if (0 === strpos($pathinfo, '/_wdt') && preg_match('#^/_wdt/(?P<token>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => '_wdt']), array (  '_controller' => 'web_profiler.controller.profiler:toolbarAction',));
            }

            if (0 === strpos($pathinfo, '/_profiler')) {
                // _profiler_home
                if ('/_profiler' === $trimmedPathinfo) {
                    $ret = array (  '_controller' => 'web_profiler.controller.profiler:homeAction',  '_route' => '_profiler_home',);
                    if ('/' === substr($pathinfo, -1)) {
                        // no-op
                    } elseif ('GET' !== $canonicalMethod) {
                        goto not__profiler_home;
                    } else {
                        return array_replace($ret, $this->redirect($rawPathinfo.'/', '_profiler_home'));
                    }

                    return $ret;
                }
                not__profiler_home:

                if (0 === strpos($pathinfo, '/_profiler/search')) {
                    // _profiler_search
                    if ('/_profiler/search' === $pathinfo) {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchAction',  '_route' => '_profiler_search',);
                    }

                    // _profiler_search_bar
                    if ('/_profiler/search_bar' === $pathinfo) {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchBarAction',  '_route' => '_profiler_search_bar',);
                    }

                }

                // _profiler_phpinfo
                if ('/_profiler/phpinfo' === $pathinfo) {
                    return array (  '_controller' => 'web_profiler.controller.profiler:phpinfoAction',  '_route' => '_profiler_phpinfo',);
                }

                // _profiler_search_results
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/search/results$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => '_profiler_search_results']), array (  '_controller' => 'web_profiler.controller.profiler:searchResultsAction',));
                }

                // _profiler_open_file
                if ('/_profiler/open' === $pathinfo) {
                    return array (  '_controller' => 'web_profiler.controller.profiler:openAction',  '_route' => '_profiler_open_file',);
                }

                // _profiler
                if (preg_match('#^/_profiler/(?P<token>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => '_profiler']), array (  '_controller' => 'web_profiler.controller.profiler:panelAction',));
                }

                // _profiler_router
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/router$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => '_profiler_router']), array (  '_controller' => 'web_profiler.controller.router:panelAction',));
                }

                // _profiler_exception
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => '_profiler_exception']), array (  '_controller' => 'web_profiler.controller.exception:showAction',));
                }

                // _profiler_exception_css
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception\\.css$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => '_profiler_exception_css']), array (  '_controller' => 'web_profiler.controller.exception:cssAction',));
                }

            }

            // _twig_error_test
            if (0 === strpos($pathinfo, '/_error') && preg_match('#^/_error/(?P<code>\\d+)(?:\\.(?P<_format>[^/]++))?$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => '_twig_error_test']), array (  '_controller' => 'twig.controller.preview_error:previewErrorPageAction',  '_format' => 'html',));
            }

        }

        // publication_show
        if ('/show' === $pathinfo) {
            return array (  '_controller' => 'PublicationBundle\\Controller\\PostController::affichagePostAction',  '_route' => 'publication_show',);
        }

        // publication_homepage
        if ('/newsfeed' === $pathinfo) {
            return array (  '_controller' => 'PublicationBundle\\Controller\\PostController::AjouterPostVIAction',  '_route' => 'publication_homepage',);
        }

        // publication_edit
        if (preg_match('#^/(?P<id_post>[^/]++)/edit$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'publication_edit']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::ModifierPostAction',));
        }

        // publication_delete
        if (preg_match('#^/(?P<id_post>[^/]++)/delete$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'publication_delete']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::DeletePostAction',));
        }

        // commentaire_add
        if (0 === strpos($pathinfo, '/new') && preg_match('#^/new/(?P<post_id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_add']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::AjouterCommentAction',));
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_commentaire_add;
            }

            return $ret;
        }
        not_commentaire_add:

        // commentaire_modif
        if (preg_match('#^/(?P<id>[^/]++)/editcom$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_modif']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::editCommentAction',));
        }

        // commentaire_delete
        if (preg_match('#^/(?P<id>[^/]++)/deletecom$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_delete']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::deleteCommentAction',));
        }

        // vote_add
        if (preg_match('#^/(?P<id_post>[^/]++)/voteup/(?P<slug>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'vote_add']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::VoteAction',));
        }

        // react_with
        if (preg_match('#^/(?P<id_post>[^/]++)/reactwith/(?P<type>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'react_with']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::ReactAction',));
        }

        // competition_homepage
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'CompetitionBundle\\Controller\\DefaultController::indexAction',  '_route' => 'competition_homepage',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_competition_homepage;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'competition_homepage'));
            }

            return $ret;
        }
        not_competition_homepage:

        if (0 === strpos($pathinfo, '/ajouter')) {
            // ajoutercompetition
            if ('/ajoutercompetition' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::ajoutercompetitionAction',  '_route' => 'ajoutercompetition',);
            }

            // ajouterticket
            if (0 === strpos($pathinfo, '/ajouterTicket') && preg_match('#^/ajouterTicket/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'ajouterticket']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::ajouterTicketAction',));
            }

            // ajouterparticipation
            if (0 === strpos($pathinfo, '/ajouterparticipation') && preg_match('#^/ajouterparticipation/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'ajouterparticipation']), array (  '_controller' => 'CompetitionBundle\\Controller\\ParticipationController::ajouterParticipationAction',));
            }

        }

        elseif (0 === strpos($pathinfo, '/affichercomp')) {
            // affichercompetition
            if ('/affichercompetition' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::afficherCompetitionAction',  '_route' => 'affichercompetition',);
            }

            // affichercomp
            if ('/affichercomp' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::afficherCompAction',  '_route' => 'affichercomp',);
            }

            // affichercompetitionUser
            if ('/affichercompetitionUser' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::afficherCompetitionUserAction',  '_route' => 'affichercompetitionUser',);
            }

            // affichercompetitionAdmin
            if ('/affichercompetitionAdmin' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::afficherCompetitionAdminAction',  '_route' => 'affichercompetitionAdmin',);
            }

        }

        elseif (0 === strpos($pathinfo, '/supprimer')) {
            if (0 === strpos($pathinfo, '/supprimercompetition')) {
                // supprimercompetition
                if (preg_match('#^/supprimercompetition/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'supprimercompetition']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::supprimerCompetitionAction',));
                }

                // supprimercompetitionAdmin
                if (0 === strpos($pathinfo, '/supprimercompetitionAdmin') && preg_match('#^/supprimercompetitionAdmin/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'supprimercompetitionAdmin']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::supprimerCompetitionAdminAction',));
                }

            }

            // supprimerparticipation
            if (0 === strpos($pathinfo, '/supprimerparticipation') && preg_match('#^/supprimerparticipation/(?P<id>[^/]++)/(?P<id1>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'supprimerparticipation']), array (  '_controller' => 'CompetitionBundle\\Controller\\ParticipationController::supprimerParticipationAction',));
            }

            // supprimerticket
            if (0 === strpos($pathinfo, '/supprimerticket') && preg_match('#^/supprimerticket/(?P<id>[^/]++)/(?P<id1>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'supprimerticket']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::supprimerTicketAction',));
            }

        }

        // modifiercompetition
        if (0 === strpos($pathinfo, '/modifiercompetition') && preg_match('#^/modifiercompetition/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'modifiercompetition']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::modifierCompetitionAction',));
        }

        // Ticket
        if (0 === strpos($pathinfo, '/Ticket') && preg_match('#^/Ticket/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'Ticket']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::afficherTicketAction',));
        }

        // detailuser
        if (0 === strpos($pathinfo, '/detailuser') && preg_match('#^/detailuser/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'detailuser']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::detailuserAction',));
        }

        // fos_homepage
        if ('/home' === $pathinfo) {
            return array (  '_controller' => 'FOSBundle\\Controller\\SecurityController::redirectAction',  '_route' => 'fos_homepage',);
        }

        // homepage
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'AppBundle\\Controller\\DefaultController::indexAction',  '_route' => 'homepage',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_homepage;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'homepage'));
            }

            return $ret;
        }
        not_homepage:

        if (0 === strpos($pathinfo, '/login')) {
            // fos_user_security_login
            if ('/login' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.security.controller:loginAction',  '_route' => 'fos_user_security_login',);
                if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                    $allow = array_merge($allow, ['GET', 'POST']);
                    goto not_fos_user_security_login;
                }

                return $ret;
            }
            not_fos_user_security_login:

            // fos_user_security_check
            if ('/login_check' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.security.controller:checkAction',  '_route' => 'fos_user_security_check',);
                if (!in_array($requestMethod, ['POST'])) {
                    $allow = array_merge($allow, ['POST']);
                    goto not_fos_user_security_check;
                }

                return $ret;
            }
            not_fos_user_security_check:

        }

        // fos_user_security_logout
        if ('/logout' === $pathinfo) {
            $ret = array (  '_controller' => 'fos_user.security.controller:logoutAction',  '_route' => 'fos_user_security_logout',);
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_fos_user_security_logout;
            }

            return $ret;
        }
        not_fos_user_security_logout:

        if (0 === strpos($pathinfo, '/profile')) {
            // fos_user_profile_show
            if ('/profile' === $trimmedPathinfo) {
                $ret = array (  '_controller' => 'fos_user.profile.controller:showAction',  '_route' => 'fos_user_profile_show',);
                if ('/' === substr($pathinfo, -1)) {
                    // no-op
                } elseif ('GET' !== $canonicalMethod) {
                    goto not_fos_user_profile_show;
                } else {
                    return array_replace($ret, $this->redirect($rawPathinfo.'/', 'fos_user_profile_show'));
                }

                if (!in_array($canonicalMethod, ['GET'])) {
                    $allow = array_merge($allow, ['GET']);
                    goto not_fos_user_profile_show;
                }

                return $ret;
            }
            not_fos_user_profile_show:

            // fos_user_profile_edit
            if ('/profile/edit' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.profile.controller:editAction',  '_route' => 'fos_user_profile_edit',);
                if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                    $allow = array_merge($allow, ['GET', 'POST']);
                    goto not_fos_user_profile_edit;
                }

                return $ret;
            }
            not_fos_user_profile_edit:

            // fos_user_change_password
            if ('/profile/change-password' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.change_password.controller:changePasswordAction',  '_route' => 'fos_user_change_password',);
                if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                    $allow = array_merge($allow, ['GET', 'POST']);
                    goto not_fos_user_change_password;
                }

                return $ret;
            }
            not_fos_user_change_password:

        }

        elseif (0 === strpos($pathinfo, '/register')) {
            // fos_user_registration_check_email
            if ('/register/check-email' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.registration.controller:checkEmailAction',  '_route' => 'fos_user_registration_check_email',);
                if (!in_array($canonicalMethod, ['GET'])) {
                    $allow = array_merge($allow, ['GET']);
                    goto not_fos_user_registration_check_email;
                }

                return $ret;
            }
            not_fos_user_registration_check_email:

            if (0 === strpos($pathinfo, '/register/confirm')) {
                // fos_user_registration_confirm
                if (preg_match('#^/register/confirm/(?P<token>[^/]++)$#sD', $pathinfo, $matches)) {
                    $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'fos_user_registration_confirm']), array (  '_controller' => 'fos_user.registration.controller:confirmAction',));
                    if (!in_array($canonicalMethod, ['GET'])) {
                        $allow = array_merge($allow, ['GET']);
                        goto not_fos_user_registration_confirm;
                    }

                    return $ret;
                }
                not_fos_user_registration_confirm:

                // fos_user_registration_confirmed
                if ('/register/confirmed' === $pathinfo) {
                    $ret = array (  '_controller' => 'fos_user.registration.controller:confirmedAction',  '_route' => 'fos_user_registration_confirmed',);
                    if (!in_array($canonicalMethod, ['GET'])) {
                        $allow = array_merge($allow, ['GET']);
                        goto not_fos_user_registration_confirmed;
                    }

                    return $ret;
                }
                not_fos_user_registration_confirmed:

            }

            // fos_user_registration_register
            if ('/register' === $pathinfo) {
                return array (  '_controller' => 'AppBundle\\Controller\\RegistrationController::registerAction',  '_route' => 'fos_user_registration_register',);
            }

        }

        elseif (0 === strpos($pathinfo, '/resetting')) {
            // fos_user_resetting_request
            if ('/resetting/request' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.resetting.controller:requestAction',  '_route' => 'fos_user_resetting_request',);
                if (!in_array($canonicalMethod, ['GET'])) {
                    $allow = array_merge($allow, ['GET']);
                    goto not_fos_user_resetting_request;
                }

                return $ret;
            }
            not_fos_user_resetting_request:

            // fos_user_resetting_reset
            if (0 === strpos($pathinfo, '/resetting/reset') && preg_match('#^/resetting/reset/(?P<token>[^/]++)$#sD', $pathinfo, $matches)) {
                $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'fos_user_resetting_reset']), array (  '_controller' => 'fos_user.resetting.controller:resetAction',));
                if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                    $allow = array_merge($allow, ['GET', 'POST']);
                    goto not_fos_user_resetting_reset;
                }

                return $ret;
            }
            not_fos_user_resetting_reset:

            // fos_user_resetting_send_email
            if ('/resetting/send-email' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.resetting.controller:sendEmailAction',  '_route' => 'fos_user_resetting_send_email',);
                if (!in_array($requestMethod, ['POST'])) {
                    $allow = array_merge($allow, ['POST']);
                    goto not_fos_user_resetting_send_email;
                }

                return $ret;
            }
            not_fos_user_resetting_send_email:

            // fos_user_resetting_check_email
            if ('/resetting/check-email' === $pathinfo) {
                $ret = array (  '_controller' => 'fos_user.resetting.controller:checkEmailAction',  '_route' => 'fos_user_resetting_check_email',);
                if (!in_array($canonicalMethod, ['GET'])) {
                    $allow = array_merge($allow, ['GET']);
                    goto not_fos_user_resetting_check_email;
                }

                return $ret;
            }
            not_fos_user_resetting_check_email:

        }

        if ('/' === $pathinfo && !$allow) {
            throw new Symfony\Component\Routing\Exception\NoConfigurationException();
        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
