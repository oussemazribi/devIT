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

/* @FOSUser/Security/login_content.html.twig */
class __TwigTemplate_bf9b383b7ebe44360ae7a5f0ea57496df5ceef4c3d9b89f5dce398f6c66a1828 extends \Twig\Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "@FOSUser/Security/login_content.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "@FOSUser/Security/login_content.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
";
        // line 4
        echo "
";
        // line 5
        if (($context["error"] ?? $this->getContext($context, "error"))) {
            // line 6
            echo "    <div>";
            echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\TranslationExtension')->trans($this->getAttribute(($context["error"] ?? $this->getContext($context, "error")), "messageKey", []), $this->getAttribute(($context["error"] ?? $this->getContext($context, "error")), "messageData", []), "security"), "html", null, true);
            echo "</div>
";
        }
        // line 8
        echo "


<head>

<link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/css/vendor/bootstrap.min.css"), "html", null, true);
        echo "\">
<!-- styles -->
<link rel=\"stylesheet\" href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/css/styles.min.css"), "html", null, true);
        echo "\">
<!-- favicon -->
<link rel=\"icon\" href=\"";
        // line 17
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/img/favicon.ico"), "html", null, true);
        echo "\">
<title>Vikinger | Home</title>
</head>
<body>
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
            <p class=\"tab-switch-button login-register-form-trigger\">Login</p>
            <!-- /TAB SWITCH BUTTON -->

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
            <img class=\"form-box-decoration overflowing\" src=\"";
        // line 71
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/img/landing/rocket.png"), "html", null, true);
        echo "\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Account Login</h2>
            <form action=\"";
        // line 76
        echo $this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("fos_user_security_check");
        echo "\" method=\"post\">
                ";
        // line 77
        if (($context["csrf_token"] ?? $this->getContext($context, "csrf_token"))) {
            // line 78
            echo "                    <input type=\"hidden\" name=\"_csrf_token\" value=\"";
            echo twig_escape_filter($this->env, ($context["csrf_token"] ?? $this->getContext($context, "csrf_token")), "html", null, true);
            echo "\" />
                ";
        }
        // line 80
        echo "                <!-- /FORM BOX TITLE -->

                <!-- FORM -->
                <form class=\"form\">
                    <!-- FORM ROW -->
                    <div class=\"form-row\">
                        <!-- FORM ITEM -->
                        <div class=\"form-item\">
                            <!-- FORM INPUT -->
                            <div class=\"form-input\">
                                <label for=\"login-username\">Username or Email</label>
                                <input type=\"text\" id=\"username\" name=\"_username\" value=\"";
        // line 91
        echo twig_escape_filter($this->env, ($context["last_username"] ?? $this->getContext($context, "last_username")), "html", null, true);
        echo "\" required=\"required\" autocomplete=\"username\" >
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
                                <input type=\"password\" id=\"password\" name=\"_password\" required=\"required\" autocomplete=\"current-password\" >

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
                            <a class=\"form-link\" href=\"/register\">Didnt have an account yet ?</a>
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
                            ";
        // line 153
        echo "                            <button  class=\"button medium secondary\" type=\"submit\" id=\"_submit\" name=\"_submit\" >";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\TranslationExtension')->trans("security.login.submit", [], "FOSUserBundle"), "html", null, true);
        echo "</button>
                            <!-- /BUTTON -->
                        </div>
                        <!-- /FORM ITEM -->
                    </div>
                    <!-- /FORM ROW -->

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

        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Create your Account!</h2>
            <!-- /FORM BOX TITLE -->
            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-email\">Your Email</label>
                            <input type=\"text\" id=\"register-email\" name=\"register_email\">
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
                            <label for=\"register-username\">Username</label>
                            <input type=\"text\" id=\"register-username\" name=\"register_username\">
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
                            <label for=\"register-password\">Password</label>
                            <input type=\"password\" id=\"register-password\" name=\"register_password\">
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
                            <input type=\"password\" id=\"register-password-repeat\" name=\"register_password_repeat\">
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
                        <!-- CHECKBOX WRAP -->
                        <div class=\"checkbox-wrap\">
                            <input type=\"checkbox\" id=\"register-newsletter\" name=\"register_newsletter\" checked>
                            <!-- CHECKBOX BOX -->
                            <div class=\"checkbox-box\">
                                <!-- ICON CROSS -->
                                <svg class=\"icon-cross\">
                                    <use xlink:href=\"#svg-cross\"></use>
                                </svg>
                                <!-- /ICON CROSS -->
                            </div>
                            <!-- /CHECKBOX BOX -->
                            <label for=\"register-newsletter\">Send me news and updates via email</label>
                        </div>
                        <!-- /CHECKBOX WRAP -->
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

            <!-- FORM TEXT -->
            <p class=\"form-text\">You'll receive a confirmation email in your inbox with a link to activate your account. If you have any problems, <a href=\"#\">contact us</a>!</p>
            <!-- /FORM TEXT -->
        </div>
        <!-- /FORM BOX -->
    </div>
    <!-- /LANDING FORM -->
</div>
<!-- /LANDING -->

<script src=\"";
        // line 331
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("template/app.bundle.min.js"), "html", null, true);
        echo "\"></script>
</body>

</html>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "@FOSUser/Security/login_content.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  404 => 331,  222 => 153,  158 => 91,  145 => 80,  139 => 78,  137 => 77,  133 => 76,  125 => 71,  68 => 17,  63 => 15,  58 => 13,  51 => 8,  45 => 6,  43 => 5,  40 => 4,  36 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html>
{% trans_default_domain 'FOSUserBundle' %}

{% if error %}
    <div>{{ error.messageKey|trans(error.messageData, 'security') }}</div>
{% endif %}



<head>

<link rel=\"stylesheet\" href=\"{{ asset('template/css/vendor/bootstrap.min.css') }}\">
<!-- styles -->
<link rel=\"stylesheet\" href=\"{{ asset('template/css/styles.min.css') }}\">
<!-- favicon -->
<link rel=\"icon\" href=\"{{ asset('template/img/favicon.ico') }}\">
<title>Vikinger | Home</title>
</head>
<body>
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
            <p class=\"tab-switch-button login-register-form-trigger\">Login</p>
            <!-- /TAB SWITCH BUTTON -->

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
            <img class=\"form-box-decoration overflowing\" src=\"{{ asset('template/img/landing/rocket.png') }}\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Account Login</h2>
            <form action=\"{{ path(\"fos_user_security_check\") }}\" method=\"post\">
                {% if csrf_token %}
                    <input type=\"hidden\" name=\"_csrf_token\" value=\"{{ csrf_token }}\" />
                {% endif %}
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
                                <input type=\"text\" id=\"username\" name=\"_username\" value=\"{{ last_username }}\" required=\"required\" autocomplete=\"username\" >
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
                                <input type=\"password\" id=\"password\" name=\"_password\" required=\"required\" autocomplete=\"current-password\" >

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
                            <a class=\"form-link\" href=\"/register\">Didnt have an account yet ?</a>
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
                            {#<button class=\"button medium secondary\">Login to your Account!</button>#}
                            <button  class=\"button medium secondary\" type=\"submit\" id=\"_submit\" name=\"_submit\" >{{ 'security.login.submit'|trans }}</button>
                            <!-- /BUTTON -->
                        </div>
                        <!-- /FORM ITEM -->
                    </div>
                    <!-- /FORM ROW -->

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

        <!-- FORM BOX -->
        <div class=\"form-box login-register-form-element\">
            <!-- FORM BOX DECORATION -->
            <img class=\"form-box-decoration\" src=\"img/landing/rocket.png\" alt=\"rocket\">
            <!-- /FORM BOX DECORATION -->

            <!-- FORM BOX TITLE -->
            <h2 class=\"form-box-title\">Create your Account!</h2>
            <!-- /FORM BOX TITLE -->
            <!-- FORM -->
            <form class=\"form\">
                <!-- FORM ROW -->
                <div class=\"form-row\">
                    <!-- FORM ITEM -->
                    <div class=\"form-item\">
                        <!-- FORM INPUT -->
                        <div class=\"form-input\">
                            <label for=\"register-email\">Your Email</label>
                            <input type=\"text\" id=\"register-email\" name=\"register_email\">
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
                            <label for=\"register-username\">Username</label>
                            <input type=\"text\" id=\"register-username\" name=\"register_username\">
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
                            <label for=\"register-password\">Password</label>
                            <input type=\"password\" id=\"register-password\" name=\"register_password\">
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
                            <input type=\"password\" id=\"register-password-repeat\" name=\"register_password_repeat\">
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
                        <!-- CHECKBOX WRAP -->
                        <div class=\"checkbox-wrap\">
                            <input type=\"checkbox\" id=\"register-newsletter\" name=\"register_newsletter\" checked>
                            <!-- CHECKBOX BOX -->
                            <div class=\"checkbox-box\">
                                <!-- ICON CROSS -->
                                <svg class=\"icon-cross\">
                                    <use xlink:href=\"#svg-cross\"></use>
                                </svg>
                                <!-- /ICON CROSS -->
                            </div>
                            <!-- /CHECKBOX BOX -->
                            <label for=\"register-newsletter\">Send me news and updates via email</label>
                        </div>
                        <!-- /CHECKBOX WRAP -->
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

            <!-- FORM TEXT -->
            <p class=\"form-text\">You'll receive a confirmation email in your inbox with a link to activate your account. If you have any problems, <a href=\"#\">contact us</a>!</p>
            <!-- /FORM TEXT -->
        </div>
        <!-- /FORM BOX -->
    </div>
    <!-- /LANDING FORM -->
</div>
<!-- /LANDING -->

<script src=\"{{ asset('template/app.bundle.min.js') }}\"></script>
</body>

</html>
", "@FOSUser/Security/login_content.html.twig", "C:\\wamp64\\www\\Rana_Web\\app\\Resources\\FOSUserBundle\\views\\Security\\login_content.html.twig");
    }
}
