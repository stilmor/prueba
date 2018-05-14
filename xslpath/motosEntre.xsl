<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head></head>
            <body>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>
    <xsl:template match="motos">
        <table border="3px">
        <xsl:for-each select="moto">
            <xsl:sort select="precio" order="ascending" />
            <!--<xsl:if test="precio &gt;=1200 and precio &lt;= 8000">-->
                <tr>
                  <td><xsl:value-of select="position()"/> </td>
                    <td><xsl:value-of select="nombre"/></td>
                    <td><img width="300px"><xsl:attribute name="src"><xsl:text>imagenes\</xsl:text>
                        <xsl:value-of select="imagen"/></xsl:attribute></img></td>
                    <td><xsl:value-of select="precio"/></td>
                    <td><xsl:value-of select="substring(nombre,1,1)"/></td>

                </tr>
            <!--</xsl:if>-->
        </xsl:for-each>
        </table>
        <br/>
        n elementos: <xsl:value-of select="count(/motos/moto[(precio = 8000 or precio &lt; 8000) and (precio = 1200 or precio &gt;1200)])"/> de un total de <xsl:value-of select="count(/motos/moto)"/>
    </xsl:template>

</xsl:stylesheet>