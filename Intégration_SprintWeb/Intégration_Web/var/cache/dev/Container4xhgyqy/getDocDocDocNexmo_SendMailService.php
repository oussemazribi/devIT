<?php

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;

// This file has been auto-generated by the Symfony Dependency Injection Component for internal use.
// Returns the private 'doc_doc_doc_nexmo.send_mail' shared service.

include_once $this->targetDirs[3].'\\vendor\\docdocdoc\\nexmo-bundle\\DocDocDoc\\NexmoBundle\\Provider\\ProviderInterface.php';
include_once $this->targetDirs[3].'\\vendor\\docdocdoc\\nexmo-bundle\\DocDocDoc\\NexmoBundle\\Provider\\Mail.php';

return $this->services['doc_doc_doc_nexmo.send_mail'] = new \DocDocDoc\NexmoBundle\Provider\Mail(NULL, 'no-reply@nexmobundle.com', ${($_ = isset($this->services['swiftmailer.mailer.default']) ? $this->services['swiftmailer.mailer.default'] : $this->load('getSwiftmailer_Mailer_DefaultService.php')) && false ?: '_'});
