<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/login', file:'authfail.css')}" media="all">
  </head>
  <body>
    <section class="authfail">
      <nsw:heading tagName="h1"><g:message code="login.authfail.label" /></nsw:heading>
      <div class="errors">
        ${flash.message}
      </div>
      <g:link class="info_link back_link" uri="/"><g:message code="defult.link.top.label" /></g:link>
    </section>
  </body>
<html>
