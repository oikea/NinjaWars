<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/signup', file:'confirm.css')}" media="all">
  </head>
  <body>
    <section class="confirm">
      <nsw:heading tagName="h1"><g:message code="signup.confirm.label" /></nsw:heading>
      <p class="notice"><g:message code="signup.confirm.notice" /></p>
      <g:form name="confirm-form" class="bottom-bordered" action="submit" method="POST" >
        <g:hiddenField name="userId" value="${input.userId}" />
        <g:hiddenField name="password" value="${input.password}" />
        <dl>
          <dt><g:message code="signupInput.userId.label"/></dt>
          <dd>
            <g:fieldValue bean="${input}" field="userId" />
          </dd>
          <dt><g:message code="signupInput.password.label"/></dt>
          <dd>
            ********
          </dd>
        </dl>
        <input id="confirm-submit" name="submit" class="default-button" type="submit"
         value="${message(code:"signup.button.submit.label")}">
        <input id="confirm-cancel" name="cancel" class="default-button" type="submit"
         value="${message(code:"signup.button.cancel.label")}">
      </g:form>
    </section>
  </body>
<html>
