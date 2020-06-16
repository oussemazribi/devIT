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

        // messagerie_homepage
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'MessagerieBundle\\Controller\\DefaultController::indexAction',  '_route' => 'messagerie_homepage',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_messagerie_homepage;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'messagerie_homepage'));
            }

            if (!in_array($canonicalMethod, ['GET'])) {
                $allow = array_merge($allow, ['GET']);
                goto not_messagerie_homepage;
            }

            return $ret;
        }
        not_messagerie_homepage:

        // test
        if (0 === strpos($pathinfo, '/try') && preg_match('#^/try/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'test']), array (  '_controller' => 'MessagerieBundle\\Controller\\MessageController::indextAction',));
            if (!in_array($canonicalMethod, ['GET'])) {
                $allow = array_merge($allow, ['GET']);
                goto not_test;
            }

            return $ret;
        }
        not_test:

        if (0 === strpos($pathinfo, '/a')) {
            if (0 === strpos($pathinfo, '/affich')) {
                // affich
                if (0 === strpos($pathinfo, '/affichMessages') && preg_match('#^/affichMessages/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'affich']), array (  '_controller' => 'MessagerieBundle\\Controller\\MessageController::affichAction',));
                }

                // affichC
                if ('/affichConversations' === $pathinfo) {
                    return array (  '_controller' => 'MessagerieBundle\\Controller\\ConversationController::affichConversationAction',  '_route' => 'affichC',);
                }

                if (0 === strpos($pathinfo, '/affichercomp')) {
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

            }

            // AjoutC
            if ('/ajoutConversation' === $pathinfo) {
                return array (  '_controller' => 'MessagerieBundle\\Controller\\ConversationController::AjoutConversationAction',  '_route' => 'AjoutC',);
            }

            if (0 === strpos($pathinfo, '/ajouter')) {
                // ajoutercompetition
                if ('/ajoutercompetition' === $pathinfo) {
                    return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::ajoutercompetitionAction',  '_route' => 'ajoutercompetition',);
                }

                // ajouterticket
                if (0 === strpos($pathinfo, '/ajouterTicket') && preg_match('#^/ajouterTicket/(?P<id>[^/]++)/(?P<type>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'ajouterticket']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::ajouterTicketAction',));
                }

                // ajouterparticipation
                if (0 === strpos($pathinfo, '/ajouterparticipation') && preg_match('#^/ajouterparticipation/(?P<id>[^/]++)/(?P<type>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'ajouterparticipation']), array (  '_controller' => 'CompetitionBundle\\Controller\\ParticipationController::ajouterParticipationAction',));
                }

            }

        }

        // Ajout
        if (0 === strpos($pathinfo, '/AjoutMessages') && preg_match('#^/AjoutMessages/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'Ajout']), array (  '_controller' => 'MessagerieBundle\\Controller\\MessageController::ajoutAction',));
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_Ajout;
            }

            return $ret;
        }
        not_Ajout:

        if (0 === strpos($pathinfo, '/s')) {
            // supp
            if (0 === strpos($pathinfo, '/suppMessages') && preg_match('#^/suppMessages/(?P<id>[^/]++)/(?P<id1>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'supp']), array (  '_controller' => 'MessagerieBundle\\Controller\\MessageController::suppAction',));
            }

            if (0 === strpos($pathinfo, '/supprimer')) {
                // suppC
                if (0 === strpos($pathinfo, '/supprimerConversation') && preg_match('#^/supprimerConversation/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'suppC']), array (  '_controller' => 'MessagerieBundle\\Controller\\ConversationController::suppConversationAction',));
                }

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

            // ajax_search
            if ('/search' === $pathinfo) {
                return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::searchAction',  '_route' => 'ajax_search',);
            }

            // publication_show
            if ('/show' === $pathinfo) {
                return array (  '_controller' => 'PublicationBundle\\Controller\\PostController::affichagePostAction',  '_route' => 'publication_show',);
            }

        }

        // update
        if (0 === strpos($pathinfo, '/updateMessages') && preg_match('#^/updateMessages/(?P<id>[^/]++)/(?P<id1>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'update']), array (  '_controller' => 'MessagerieBundle\\Controller\\MessageController::updateAction',));
        }

        // updateC
        if (0 === strpos($pathinfo, '/updateConversation') && preg_match('#^/updateConversation/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'updateC']), array (  '_controller' => 'MessagerieBundle\\Controller\\ConversationController::updateConversationAction',));
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

        // modifiercompetition
        if (0 === strpos($pathinfo, '/modifiercompetition') && preg_match('#^/modifiercompetition/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'modifiercompetition']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::modifierCompetitionAction',));
        }

        // Ticket
        if (0 === strpos($pathinfo, '/Ticket') && preg_match('#^/Ticket/(?P<id>[^/]++)/(?P<type>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'Ticket']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::afficherTicketAction',));
        }

        // detailuser
        if (0 === strpos($pathinfo, '/detailuser') && preg_match('#^/detailuser/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'detailuser']), array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::detailuserAction',));
        }

        // pdf
        if (0 === strpos($pathinfo, '/pdf') && preg_match('#^/pdf/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'pdf']), array (  '_controller' => 'CompetitionBundle\\Controller\\TicketController::pdfAction',));
        }

        // pie
        if ('/pie' === $pathinfo) {
            return array (  '_controller' => 'CompetitionBundle\\Controller\\CompetitionController::pieAction',  '_route' => 'pie',);
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

        // publication_show_one1
        if (preg_match('#^/(?P<id_post>[^/]++)/show1$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'publication_show_one1']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::showoneAction',));
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

        // commentaire_supprimer
        if (0 === strpos($pathinfo, '/supprimercommentaire') && preg_match('#^/supprimercommentaire/(?P<id_com>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_supprimer']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::deleteCommentAction',));
        }

        // vote_add
        if (preg_match('#^/(?P<id_post>[^/]++)/voteup/(?P<slug>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'vote_add']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::VoteAction',));
        }

        // react_with
        if (preg_match('#^/(?P<id_post>[^/]++)/reactwith/(?P<type>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'react_with']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::ReactAction',));
        }

        // visit_profile
        if (preg_match('#^/(?P<id_user>[^/]++)/profile$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'visit_profile']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::visitprofileAction',));
        }

        // publication_share_one
        if (preg_match('#^/(?P<id_post>[^/]++)/share$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'publication_share_one']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::shareoneAction',));
        }

        if (0 === strpos($pathinfo, '/sh')) {
            // share
            if ('/sharenow' === $pathinfo) {
                return array (  '_controller' => 'PublicationBundle\\Controller\\PostController::addpostajAction',  '_route' => 'share',);
            }

            if (0 === strpos($pathinfo, '/showonepost')) {
                // show_one_post
                if (preg_match('#^/showonepost/(?P<id_post>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'show_one_post']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::showPost1Action',));
                }

                // show_Admin_post
                if (0 === strpos($pathinfo, '/showonepostadmin') && preg_match('#^/showonepostadmin/(?P<id_post>[^/]++)$#sD', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, ['_route' => 'show_Admin_post']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::showPost1AdiminAction',));
                }

            }

            // show_Admin_posts
            if ('/showpostsadmin' === $pathinfo) {
                return array (  '_controller' => 'PublicationBundle\\Controller\\PostController::showPostforadminAction',  '_route' => 'show_Admin_posts',);
            }

        }

        // commentaire_supprimera
        if (0 === strpos($pathinfo, '/supprimercommentairea') && preg_match('#^/supprimercommentairea/(?P<id_com>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_supprimera']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::deleteCommentAAction',));
        }

        // commentaire_addad
        if (0 === strpos($pathinfo, '/newad') && preg_match('#^/newad/(?P<post_id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'commentaire_addad']), array (  '_controller' => 'PublicationBundle\\Controller\\commentaireController::AjouterCommentadAction',));
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_commentaire_addad;
            }

            return $ret;
        }
        not_commentaire_addad:

        // publication_addelete
        if (preg_match('#^/(?P<id_post>[^/]++)/deletead$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'publication_addelete']), array (  '_controller' => 'PublicationBundle\\Controller\\PostController::DeletePostadAction',));
        }

        // fos_homepage
        if ('/home' === $pathinfo) {
            return array (  '_controller' => 'FOSBundle\\Controller\\SecurityController::redirectAction',  '_route' => 'fos_homepage',);
        }

        // blog_homepage
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'BlogBundle\\Controller\\DefaultController::indexAction',  '_route' => 'blog_homepage',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_blog_homepage;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'blog_homepage'));
            }

            return $ret;
        }
        not_blog_homepage:

        if (0 === strpos($pathinfo, '/A')) {
            // blog_ajoutBlog
            if ('/Ajout' === $pathinfo) {
                return array (  '_controller' => 'BlogBundle\\Controller\\BlogController::ajoutBlogAction',  '_route' => 'blog_ajoutBlog',);
            }

            if (0 === strpos($pathinfo, '/Affiche')) {
                // blog_afficheBlog
                if ('/Affiche' === $pathinfo) {
                    return array (  '_controller' => 'BlogBundle\\Controller\\BlogController::afficheBlogAction',  '_route' => 'blog_afficheBlog',);
                }

                // blog_afficheBlogUser
                if ('/AfficheBlogUser' === $pathinfo) {
                    return array (  '_controller' => 'BlogBundle\\Controller\\BlogController::afficheBlogUserAction',  '_route' => 'blog_afficheBlogUser',);
                }

            }

            // AffichierComments
            if ('/AffichierComments/{}' === $pathinfo) {
                return array (  '_controller' => 'BlogBundle\\Controller\\BlogController::AffichierCommentsAction',  '_route' => 'AffichierComments',);
            }

        }

        // blog_supprimerBlog
        if (0 === strpos($pathinfo, '/supprimerBlog') && preg_match('#^/supprimerBlog/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'blog_supprimerBlog']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::supprimerBlogAction',));
        }

        // blog_modifierBlog
        if (0 === strpos($pathinfo, '/modifierBlog') && preg_match('#^/modifierBlog/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, ['_route' => 'blog_modifierBlog']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::modifierBlogAction',));
        }

        if (0 === strpos($pathinfo, '/voirBlog')) {
            // blog_voirBlog
            if (preg_match('#^/voirBlog/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'blog_voirBlog']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::voirBlogAction',));
            }

            // blog_voirBlogUser
            if (0 === strpos($pathinfo, '/voirBlogUser') && preg_match('#^/voirBlogUser/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'blog_voirBlogUser']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::voirBlogUserAction',));
            }

        }

        // add_comment
        if (0 === strpos($pathinfo, '/addcomment') && preg_match('#^/addcomment/(?P<post_id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'add_comment']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::addCommentAction',));
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_add_comment;
            }

            return $ret;
        }
        not_add_comment:

        // delete_comment
        if (0 === strpos($pathinfo, '/deletecomment') && preg_match('#^/deletecomment/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
            $ret = $this->mergeDefaults(array_replace($matches, ['_route' => 'delete_comment']), array (  '_controller' => 'BlogBundle\\Controller\\BlogController::deleteCommentAction',));
            if (!in_array($canonicalMethod, ['GET', 'POST'])) {
                $allow = array_merge($allow, ['GET', 'POST']);
                goto not_delete_comment;
            }

            return $ret;
        }
        not_delete_comment:

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

        elseif (0 === strpos($pathinfo, '/notifications')) {
            // notification_list
            if (preg_match('#^/notifications/(?P<notifiable>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'notification_list']), array (  '_controller' => 'Mgilet\\NotificationBundle\\Controller\\NotificationController::listAction',));
            }

            // notification_mark_as_seen
            if (preg_match('#^/notifications/(?P<notifiable>[^/]++)/mark_as_seen/(?P<notification>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'notification_mark_as_seen']), array (  '_controller' => 'Mgilet\\NotificationBundle\\Controller\\NotificationController::markAsSeenAction',));
            }

            // notification_mark_as_unseen
            if (preg_match('#^/notifications/(?P<notifiable>[^/]++)/mark_as_unseen/(?P<notification>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'notification_mark_as_unseen']), array (  '_controller' => 'Mgilet\\NotificationBundle\\Controller\\NotificationController::markAsUnSeenAction',));
            }

            // notification_mark_all_as_seen
            if (preg_match('#^/notifications/(?P<notifiable>[^/]++)/markAllAsSeen$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, ['_route' => 'notification_mark_all_as_seen']), array (  '_controller' => 'Mgilet\\NotificationBundle\\Controller\\NotificationController::markAllAsSeenAction',));
            }

        }

        if ('/' === $pathinfo && !$allow) {
            throw new Symfony\Component\Routing\Exception\NoConfigurationException();
        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
