<%@ page import="org.eldersoftware.ninjawars.player.UnitType" %>
<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/tutorial', file:'typeSelect.css')}" media="all">
  </head>
  <body>
    <section class="type-select">
      <nsw:heading tagName="h1"><g:message code="tutorial.typeSelect.label" /></nsw:heading>
      <sg:faceMessage image="test.jpg">
        <g:message code="tutorial.typeSelect.navigation.message" />
      </sg:faceMessage>
      <g:form name="type-select-form" class="bottom-bordered" action="execute" method="POST" >
        <input type="hidden" value="" name="__select">
        <ul>
          <g:each in="${UnitType.list(sort:'id')}" var="unitType">
            <li class="${unitType.code}">
              <r:img dir="/images/tutorial" file="unit-select-${unitType.code}.jpg" />
              <p class="description">${unitType.description.encodeAsHTML()}</p>
              <input class="default-button" type="submit" name="${unitType.code}"
               value="${message(code:"tutorial.typeSelect.select.label", args:[unitType.name])}">
            </li>
          </g:each>
        </ul>
      </g:form>
      <p class="notice"><g:message code="tutorial.typeSelect.notice" /></p>
    </section>
  </body>
<html>
