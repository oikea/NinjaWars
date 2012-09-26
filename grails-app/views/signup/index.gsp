<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/signup', file:'index.css')}" media="all">
  </head>
  <body>
    <g:hasErrors bean="${input}">
      <div class="errors">
        <g:renderErrors bean="${input}" as="list" />
      </div>
    </g:hasErrors>
    <section class="signup">
      <nsw:heading tagName="h1"><g:message code="signup.label" /></nsw:heading>
      <g:form name="signup-form" class="bottom-bordered" action="confirm" method="POST" >
        <dl>
          <dt><label for="userId"><g:message code="signupInput.userId.label"/></label></dt>
          <dd>
            <g:textField name="userId" value="${input?.userId}" spellcheck="false" />
          </dd>
          <dt><label for="password"><g:message code="signupInput.password.label"/></label></dt>
          <dd>
            <g:passwordField name="password" />
          </dd>
          <dt><label for="confirmPassword"><g:message code="signupInput.confirmPassword.label"/></label></dt>
          <dd>
            <g:passwordField name="confirmPassword" />
          </dd>
        </dl>
        <input id="signup-submit" class="default-button" type="submit"
         value="${message(code:"default.button.create.label")}">
      </g:form>
      <g:link class="info_link back_link" uri="/"><g:message code="defult.link.top.label" /></g:link>
    </section>
  </body>
<html>
