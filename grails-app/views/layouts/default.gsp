<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8">

    <title><g:message code="default.app.label" /></title>

    <r:require module="jquery"/>
    <r:require module="common"/>
    <r:layoutResources/>

    <g:layoutHead />
  </head>
  <body>
    <div id="page-area">
      <sec:ifLoggedIn>
      </sec:ifLoggedIn>
      <g:layoutBody />
      <sec:ifLoggedIn>
      </sec:ifLoggedIn>

      <div id="siteinfo">
        <small id="copyright"><g:message code="default.copylight.label" /></small>
        <div id="powered">
          <a href="http://grails.org" target="_blank"><r:img dir="images/common" file="powered_by.png" /></a>
        </div>
        <div id="version"><nsw:version /></div>
      </div>
    </div>
    <r:layoutResources/>
  </body>
</html>
