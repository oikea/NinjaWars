<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/top', file:'base.css')}" media="all">

    <r:require module="top"/>
  </head>
  <body>
    <g:if test="${titleImageUrl != null}">
      <h1><r:img uri="${titleImageUrl}" alt="${message(code:'default.app.label')}" /></h1>
    </g:if>
    <p id="explanation"><g:message code="top.explanation.label" /></p>

    <sec:ifLoggedIn>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
      <section class="login">
        <nsw:heading tagName="h2"><g:message code="login.label" /></nsw:heading>
        <form id="login-form" class="bottom-bordered" action="${loginUrl}" method="POST" autocomplete="off">
          <dl>
            <dt><label for="userId"><g:message code="account.userId.label"/></label></dt>
            <dd><input id="userId" type="text" name="j_username"></dd>
            <dt><label for="password"><g:message code="account.password.label"/></label></dt>
            <dd><input id="password" type='password' name="j_password"></dd>
          </dl>
          <input id="login-submit" class="default-button" type="submit"
           value="${message(code:"login.button.login.label")}">
        </form>
        <div class="bottom">
          <g:link class="default-button" uri="/signup">
            <g:message code="login.button.signup.label" />
          </g:link>
        </div>
      </section>
    </sec:ifNotLoggedIn>

    

    <section id="topics">
      <nsw:heading tagName="h2"><g:message code="topics.label" /></nsw:heading>
      <ul class="link_list bottom-bordered">
        <li><a href="#">ダミー</a></li>
        <li><a href="#">ダミー</a></li>
        <li><a href="#">ダミー</a></li>
        <li><a href="#">ダミー</a></li>
      </ul>
      <div class="bottom">
        <a class="default-button" href="#">
          <g:message code="defult.button.more.label" />
        </a>
      </div>
    </section>

    <sec:ifLoggedIn>
    </sec:ifLoggedIn>
  </body>
<html>
