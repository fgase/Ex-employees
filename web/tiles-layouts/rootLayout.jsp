<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<html:html>
    <head>
        <%-- We rely on tiles-defs.xml to set the title --%>
        <title>Base de donn�es des employ�s<tiles:getAsString name="titleString"/></title>
        <html:base/>
    </head>
    <body>
        <tiles:insert attribute="header"/>
        
         <tiles:insert attribute="panel"/>
        
        <tiles:insert attribute="footer"/>

    </body>
</html:html>
