<sg:setPlayer />
<html>
  <head>
    <meta name="layout" content="default">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/mypage', file:'index.css')}" media="all">
  </head>
  <body>
    <dl id="top-status"><%--
  --%><dt class="stamina"><g:message code="player.stamina.label" />:</dt><%--
  --%><dd class="stamina">${player.stamina}<span class="max">/${player.maxStamina}</span></dd><%--
  --%><dt class="attack"><g:message code="player.attackCost.label" />:</dt><%--
  --%><dd class="attack">${player.attackCost}<span class="max">/${player.maxAttackCost}</span></dd><%--
  --%><dt class="defence"><g:message code="player.defenceCost.label" />:</dt><%--
  --%><dd class="defence">${player.defenceCost}<span class="max">/${player.maxDefenceCost}</span></dd><%--
--%></dl>
    <ul id="inner-menu"><%--
  --%><li><%--
    --%><g:link controller="mypageQuest"><%--
      --%><g:img dir="images/mypage" file="menu-quest.png" /><%--
    --%></g:link><%--
  --%></li><%--
  --%><li><%--
    --%><g:link controller="mypageBattle"><%--
      --%><g:img dir="images/mypage" file="menu-battle.png" /><%--
    --%></g:link><%--
  --%></li><%--
  --%><li><%--
    --%><g:link controller="mypageStrength"><%--
      --%><g:img dir="images/mypage" file="menu-strength.png" /><%--
    --%></g:link><%--
  --%></li><%--
  --%><li><%--
    --%><g:link controller="mypageUnion"><%--
      --%><g:img dir="images/mypage" file="menu-union.png" /><%--
    --%></g:link><%--
  --%></li><%--
--%></ul>
    <section id="middle-status">
      <div class="wrapper">
        <dl><%--
      --%><dt class="level"><g:message code="player.level.label" />:</dt><%--
      --%><dd class="level">${player.level}</dd><%--
      --%><dt class="experience"><g:message code="player.experience.label" />:</dt><%--
      --%><dd class="experience">${player.experience}</dd><%--
      --%><dt class="money"><g:message code="player.money.label" />:</dt><%--
      --%><dd class="money">${player.money}</dd><%--
      --%><dt class="friendPoint"><g:message code="player.friendPoint.label" />:</dt><%--
      --%><dd class="friendPoint">${player.friendPoint}</dd><%--
      --%><dt class="friend"><g:message code="player.friend.label" />:</dt><%--
      --%><dd class="friend">${player.friends.size()}<span class="max">/${player.maxFriends}</span></dd><%--
      --%><dt class="unit"><g:message code="player.unit.label" />:</dt><%--
      --%><dd class="unit">${player.units.size()}<span class="max">/${player.maxUnits}</span></dd><%--
    --%></dl>
      </div>
    </section>
  </body>
<html>
