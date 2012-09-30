<%@ page import="org.eldersoftware.ninjawars.player.UnitType" %>
<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/tutorial', file:'typeConfirm.css')}" media="all">
  </head>
  <body>
    <section class="type-confirm">
      <nsw:heading tagName="h1"><g:message code="tutorial.typeConfirm.label" /></nsw:heading>
      <sg:faceMessage image="nancy00.jpg">
        <g:message code="tutorial.typeConfirm.navigation.message" />
      </sg:faceMessage>
      <g:form name="type-confirm-form" class="bottom-bordered" action="execute" method="POST" >
        <input type="hidden" value="" name="__select">
        <ul>
          <li class="${unitType.code}">
            <r:img dir="/images/tutorial" file="unit-select-${unitType.code}.jpg" />
            <p class="description">${unitType.description.encodeAsHTML()}</p>
            <input class="default-button" type="submit" name="next"
             value="${message(code:"tutorial.typeConfirm.next.label")}">
          </li>
        </ul>
        <input class="link-button" type="submit" name="prev"
         value="${message(code:"tutorial.typeConfirm.previous.label")}">
      </g:form>
      <p class="notice"><g:message code="tutorial.typeSelect.notice" /></p>
    </section>
  </body>
<html>
