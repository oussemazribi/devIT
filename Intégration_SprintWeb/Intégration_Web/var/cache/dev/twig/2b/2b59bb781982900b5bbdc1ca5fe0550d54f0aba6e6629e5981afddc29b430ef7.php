<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* @FOSUser/Registration/register_content.html.twig */
class __TwigTemplate_266e6537c023d3737311dba473a2494b24baf279b2f58ff72fbd5f09537d0c0b extends \Twig\Template
{
    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "@FOSUser/Registration/register_content.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "@FOSUser/Registration/register_content.html.twig"));

        // line 2
        echo "

<link rel=\"stylesheet\" href=\"";
        // line 4
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/css/vendor/bootstrap.min.css"), "html", null, true);
        echo "\">
<!-- styles -->
<link rel=\"stylesheet\" href=\"";
        // line 6
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/css/styles.min.css"), "html", null, true);
        echo "\">
<!-- favicon -->
<link rel=\"icon\" href=\"";
        // line 8
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/img/favicon.ico"), "html", null, true);
        echo "\">
<title>Vikinger | Home</title>


<img class=\"form-box-decoration\" src=\"img/landing/404-bg.png\" alt=\"rocket\">



<!-- LANDING -->
<div class=\"landing\">
    <!-- LANDING DECORATION -->
    <div class=\"landing-decoration\"></div>
    <!-- /LANDING DECORATION -->

    <!-- LANDING INFO -->
    <div class=\"landing-info\">
        <!-- LOGO -->
        <div class=\"logo\">
            <!-- ICON LOGO VIKINGER -->
            <svg class=\"icon-logo-vikinger\">
                <use xlink:href=\"#svg-logo-vikinger\"></use>
            </svg>
            <!-- /ICON LOGO VIKINGER -->
        </div>
        <!-- /LOGO -->

        <!-- LANDING INFO PRETITLE -->
        <h2 class=\"landing-info-pretitle\">Welcome to</h2>
        <!-- /LANDING INFO PRETITLE -->

        <!-- LANDING INFO TITLE -->
        <h1 class=\"landing-info-title\">Vikinger</h1>
        <!-- /LANDING INFO TITLE -->

        <!-- LANDING INFO TEXT -->
        <p class=\"landing-info-text\">The next generation social network &amp; community! Connect with your friends and play with our quests and badges gamification system!</p>
        <!-- /LANDING INFO TEXT -->

        <!-- TAB SWITCH -->
        <div class=\"tab-switch\">


            <!-- TAB SWITCH BUTTON -->
            <p class=\"tab-switch-button login-register-form-trigger\">Register</p>
            <!-- /TAB SWITCH BUTTON -->
        </div>
        <!-- /TAB SWITCH -->
    </div>
    <!-- /LANDING INFO -->

    <!-- LANDING FORM -->
    <div class=\"landing-form\">
        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration overflowing\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Account Login</h2>
            <!-- /FORM BOX TITLE -->

            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"login-username\">Username or Email</label>
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"login-password\">Password</label>
                            <input type=\"password\" id=\"login-password\" name=\"login_password\">
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->




                <!-- FORM ROW -->
                <div class=\"form-row space-between\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- CHECKBOX WRAP -->
                        <div class=\"checkbox-wrap\">
                            <input type=\"checkbox\" id=\"login-remember\" name=\"login_remember\" checked>
                            <!-- CHECKBOX BOX -->
                            <div class=\"checkbox-box\">
                                <!-- ICON CROSS -->
                                <svg class=\"icon-cross\">
                                    <use xlink:href=\"#svg-cross\"></use>
                                </svg>
                                <!-- /ICON CROSS -->
                            </div>
                            <!-- /CHECKBOX BOX -->
                            <label for=\"login-remember\">Remember Me</label>
                        </div>
                        <!-- /CHECKBOX WRAP -->
                    </div>
                    <!-- /FORM ITEM -->

                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM LINK -->
                        <a class=\"form-link\" href=\"#\">Forgot Password?</a>
                        <!-- /FORM LINK -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- BUTTON -->
                        <button class=\"button medium secondary\">Login to your Account!</button>
                        <!-- /BUTTON -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->
            </form>
            <!-- /FORM -->

            <!-- LINED TEXT -->
            <p class=\"lined-text\">Login with your Social Account</p>
            <!-- /LINED TEXT -->

            <!-- SOCIAL LINKS -->
            <div class=\"social-links\">
                <!-- SOCIAL LINK -->
                <a class=\"social-link facebook\" href=\"#\">
                    <!-- ICON FACEBOOK -->
                    <svg class=\"icon-facebook\">
                        <use xlink:href=\"#svg-facebook\"></use>
                    </svg>
                    <!-- /ICON FACEBOOK -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link twitter\" href=\"#\">
                    <!-- ICON TWITTER -->
                    <svg class=\"icon-twitter\">
                        <use xlink:href=\"#svg-twitter\"></use>
                    </svg>
                    <!-- /ICON TWITTER -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link twitch\" href=\"#\">
                    <!-- ICON TWITCH -->
                    <svg class=\"icon-twitch\">
                        <use xlink:href=\"#svg-twitch\"></use>
                    </svg>
                    <!-- /ICON TWITCH -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link youtube\" href=\"#\">
                    <!-- ICON YOUTUBE -->
                    <svg class=\"icon-youtube\">
                        <use xlink:href=\"#svg-youtube\"></use>
                    </svg>
                    <!-- /ICON YOUTUBE -->
                </a>
                <!-- /SOCIAL LINK -->
            </div>
            <!-- /SOCIAL LINKS -->
        </div>
        <!-- /FORM BOX -->










        ";
        // line 209
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock(($context["form"] ?? $this->getContext($context, "form")), 'form_start', ["method" => "post", "action" => $this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("fos_user_registration_register"), "attr" => ["class" => "fos_user_registration_register"]]);
        echo "

        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Create your Account!</h2>
            <!-- /FORM BOX TITLE -->
            <br><br>

            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-username\">Email</label>

                            ";
        // line 232
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "email", []), 'widget', ["attr" => ["id" => "register-email", "name" => "register_email"]]);
        echo "


                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-username\">Username</label>


                            ";
        // line 250
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "username", []), 'widget', ["attr" => ["id" => "register-username", "name" => "register_username"]]);
        echo "

                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <br>

                <!-- FORM SELECT -->
                <div class=\"form-select\">
                    <label for=\"downloads-filter-category\">Type de Compte</label>
                    ";
        // line 264
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "typecompte", []), 'widget', ["attr" => ["id" => "downloads-filter-category", "name" => "downloads_filter_category"]]);
        echo "

                    <!-- FORM SELECT ICON -->
                    <svg class=\"form-select-icon icon-small-arrow\">
                        <use xlink:href=\"#svg-small-arrow\"></use>
                    </svg>
                    <!-- /FORM SELECT ICON -->
                </div>
                <!-- /FORM SELECT -->


                <br>
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-password-repeat\">Password</label>

                            ";
        // line 284
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "plainPassword", []), "first", []), 'row', ["attr" => ["placeholder" => $this->env->getExtension('Symfony\Bridge\Twig\Extension\TranslationExtension')->trans("", [], "FOSUserBundle")], "label" => false]);
        echo "

                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-password-repeat\">Repeat Password</label>


                            ";
        // line 302
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "plainPassword", []), "second", []), 'row', ["attr" => ["placeholder" => $this->env->getExtension('Symfony\Bridge\Twig\Extension\TranslationExtension')->trans("", [], "FOSUserBundle")], "label" => false]);
        echo "
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <div class=\"custom-file\">
                            <label class=\"custom-file-label\" for=\"customFile\">Choose file</label>
                            ";
        // line 316
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "file", []), 'widget', ["attr" => ["id" => "customFile", "class" => "custom-file-input"]]);
        echo "
                        </div>
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row space-between\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM LINK -->
                        <a class=\"form-link\" href=\"/login\">Already Have An Account ?</a>
                        <!-- /FORM LINK -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->




                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- BUTTON -->
                        <button class=\"button medium primary\">Register Now!</button>
                        <!-- /BUTTON -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->
            </form>
            <!-- /FORM -->
            ";
        // line 351
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock(($context["form"] ?? $this->getContext($context, "form")), 'form_end');
        echo "


            <!-- FORM TEXT -->
            <p class=\"form-text\">You'll receive a confirmation email in your inbox with a link to activate your account. If you have any problems, <a href=\"#\">contact us</a>!</p>
            <!-- /FORM TEXT -->
        </div>
        <!-- /FORM BOX -->
    </div>
    <!-- /LANDING FORM -->
</div>
<!-- /LANDING -->





















<!-- app -->
<script src=\"";
        // line 385
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/app.bundle.min.js"), "html", null, true);
        echo "\"></script>




















";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "@FOSUser/Registration/register_content.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  454 => 385,  417 => 351,  379 => 316,  362 => 302,  341 => 284,  318 => 264,  301 => 250,  280 => 232,  254 => 209,  50 => 8,  45 => 6,  40 => 4,  36 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Source("{% trans_default_domain 'FOSUserBundle' %}


<link rel=\"stylesheet\" href=\"{{ asset('template/css/vendor/bootstrap.min.css') }}\">
<!-- styles -->
<link rel=\"stylesheet\" href=\"{{ asset('template/css/styles.min.css') }}\">
<!-- favicon -->
<link rel=\"icon\" href=\"{{ asset('template/img/favicon.ico') }}\">
<title>Vikinger | Home</title>


<img class=\"form-box-decoration\" src=\"img/landing/404-bg.png\" alt=\"rocket\">



<!-- LANDING -->
<div class=\"landing\">
    <!-- LANDING DECORATION -->
    <div class=\"landing-decoration\"></div>
    <!-- /LANDING DECORATION -->

    <!-- LANDING INFO -->
    <div class=\"landing-info\">
        <!-- LOGO -->
        <div class=\"logo\">
            <!-- ICON LOGO VIKINGER -->
            <svg class=\"icon-logo-vikinger\">
                <use xlink:href=\"#svg-logo-vikinger\"></use>
            </svg>
            <!-- /ICON LOGO VIKINGER -->
        </div>
        <!-- /LOGO -->

        <!-- LANDING INFO PRETITLE -->
        <h2 class=\"landing-info-pretitle\">Welcome to</h2>
        <!-- /LANDING INFO PRETITLE -->

        <!-- LANDING INFO TITLE -->
        <h1 class=\"landing-info-title\">Vikinger</h1>
        <!-- /LANDING INFO TITLE -->

        <!-- LANDING INFO TEXT -->
        <p class=\"landing-info-text\">The next generation social network &amp; community! Connect with your friends and play with our quests and badges gamification system!</p>
        <!-- /LANDING INFO TEXT -->

        <!-- TAB SWITCH -->
        <div class=\"tab-switch\">


            <!-- TAB SWITCH BUTTON -->
            <p class=\"tab-switch-button login-register-form-trigger\">Register</p>
            <!-- /TAB SWITCH BUTTON -->
        </div>
        <!-- /TAB SWITCH -->
    </div>
    <!-- /LANDING INFO -->

    <!-- LANDING FORM -->
    <div class=\"landing-form\">
        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration overflowing\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Account Login</h2>
            <!-- /FORM BOX TITLE -->

            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"login-username\">Username or Email</label>
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"login-password\">Password</label>
                            <input type=\"password\" id=\"login-password\" name=\"login_password\">
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->




                <!-- FORM ROW -->
                <div class=\"form-row space-between\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- CHECKBOX WRAP -->
                        <div class=\"checkbox-wrap\">
                            <input type=\"checkbox\" id=\"login-remember\" name=\"login_remember\" checked>
                            <!-- CHECKBOX BOX -->
                            <div class=\"checkbox-box\">
                                <!-- ICON CROSS -->
                                <svg class=\"icon-cross\">
                                    <use xlink:href=\"#svg-cross\"></use>
                                </svg>
                                <!-- /ICON CROSS -->
                            </div>
                            <!-- /CHECKBOX BOX -->
                            <label for=\"login-remember\">Remember Me</label>
                        </div>
                        <!-- /CHECKBOX WRAP -->
                    </div>
                    <!-- /FORM ITEM -->

                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM LINK -->
                        <a class=\"form-link\" href=\"#\">Forgot Password?</a>
                        <!-- /FORM LINK -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- BUTTON -->
                        <button class=\"button medium secondary\">Login to your Account!</button>
                        <!-- /BUTTON -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->
            </form>
            <!-- /FORM -->

            <!-- LINED TEXT -->
            <p class=\"lined-text\">Login with your Social Account</p>
            <!-- /LINED TEXT -->

            <!-- SOCIAL LINKS -->
            <div class=\"social-links\">
                <!-- SOCIAL LINK -->
                <a class=\"social-link facebook\" href=\"#\">
                    <!-- ICON FACEBOOK -->
                    <svg class=\"icon-facebook\">
                        <use xlink:href=\"#svg-facebook\"></use>
                    </svg>
                    <!-- /ICON FACEBOOK -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link twitter\" href=\"#\">
                    <!-- ICON TWITTER -->
                    <svg class=\"icon-twitter\">
                        <use xlink:href=\"#svg-twitter\"></use>
                    </svg>
                    <!-- /ICON TWITTER -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link twitch\" href=\"#\">
                    <!-- ICON TWITCH -->
                    <svg class=\"icon-twitch\">
                        <use xlink:href=\"#svg-twitch\"></use>
                    </svg>
                    <!-- /ICON TWITCH -->
                </a>
                <!-- /SOCIAL LINK -->

                <!-- SOCIAL LINK -->
                <a class=\"social-link youtube\" href=\"#\">
                    <!-- ICON YOUTUBE -->
                    <svg class=\"icon-youtube\">
                        <use xlink:href=\"#svg-youtube\"></use>
                    </svg>
                    <!-- /ICON YOUTUBE -->
                </a>
                <!-- /SOCIAL LINK -->
            </div>
            <!-- /SOCIAL LINKS -->
        </div>
        <!-- /FORM BOX -->










        {{ form_start(form, {'method': 'post', 'action': path('fos_user_registration_register'), 'attr': {'class': 'fos_user_registration_register'}}) }}

        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Create your Account!</h2>
            <!-- /FORM BOX TITLE -->
            <br><br>

            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-username\">Email</label>

                            {{ form_widget(form.email, {'attr':{'id':\"register-email\",'name':\"register_email\"}}) }}


                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-username\">Username</label>


                            {{ form_widget(form.username, {'attr':{'id':\"register-username\",'name':\"register_username\"}}) }}

                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <br>

                <!-- FORM SELECT -->
                <div class=\"form-select\">
                    <label for=\"downloads-filter-category\">Type de Compte</label>
                    {{ form_widget(form.typecompte, {'attr':{'id':\"downloads-filter-category\",'name':\"downloads_filter_category\"}}) }}

                    <!-- FORM SELECT ICON -->
                    <svg class=\"form-select-icon icon-small-arrow\">
                        <use xlink:href=\"#svg-small-arrow\"></use>
                    </svg>
                    <!-- /FORM SELECT ICON -->
                </div>
                <!-- /FORM SELECT -->


                <br>
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-password-repeat\">Password</label>

                            {{ form_row(form.plainPassword.first, { 'attr': {'placeholder': ''|trans}, 'label': false }) }}

                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-password-repeat\">Repeat Password</label>


                            {{ form_row(form.plainPassword.second, { 'attr': {'placeholder': ''|trans}, 'label': false }) }}
                        </div>
                        <!-- /FORM INPUT -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <div class=\"custom-file\">
                            <label class=\"custom-file-label\" for=\"customFile\">Choose file</label>
                            {{ form_widget(form.file,{'attr':{ 'id':'customFile','class':'custom-file-input'}})}}
                        </div>
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->

                <!-- FORM ROW -->
                <div class=\"form-row space-between\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM LINK -->
                        <a class=\"form-link\" href=\"/login\">Already Have An Account ?</a>
                        <!-- /FORM LINK -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->




                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- BUTTON -->
                        <button class=\"button medium primary\">Register Now!</button>
                        <!-- /BUTTON -->
                    </div>
                    <!-- /FORM ITEM -->
                </div>
                <!-- /FORM ROW -->
            </form>
            <!-- /FORM -->
            {{ form_end(form) }}


            <!-- FORM TEXT -->
            <p class=\"form-text\">You'll receive a confirmation email in your inbox with a link to activate your account. If you have any problems, <a href=\"#\">contact us</a>!</p>
            <!-- /FORM TEXT -->
        </div>
        <!-- /FORM BOX -->
    </div>
    <!-- /LANDING FORM -->
</div>
<!-- /LANDING -->





















<!-- app -->
<script src=\"{{ asset('template/app.bundle.min.js') }}\"></script>




















", "@FOSUser/Registration/register_content.html.twig", "C:\\wamp64\\www\\Rana_Web\\app\\Resources\\FOSUserBundle\\views\\Registration\\register_content.html.twig");
    }
}
