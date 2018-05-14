<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .bajo{
                    background-color: cornflowerblue;
                    }
                    .medio
                    {
                        background-color: darkcyan;
                    }
                    .alto
                    {
                        background-color: blue;
                    }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
        <xsl:template match="motos">
            <table border="3px">
                <xsl:sort select="precio" order="ascending"/>
                <tr>
                    <td>Moto</td>
                    <td>Precio</td>
                </tr>
                <xsl:for-each select="moto">

                    <xsl:if test="precio &gt;= 1000">
                        <tr>
                        <td class="bajo"><xsl:value-of select="nombre"/></td>
                        <td class="bajo"><xsl:value-of select="precio"/></td>
                        </tr>
                    </xsl:if>

                        <xsl:if test="precio &gt;=8000">
                            <tr>
                            <td class="medio"><xsl:value-of select="nombre"/></td>
                            <td class="medio"><xsl:value-of select="precio"/></td>
                            </tr>
                        </xsl:if>

                        <xsl:if test="precio &gt;= 1500">
                            <tr>
                            <td class="alto"><xsl:value-of select="nombre"/></td>
                            <td class="alto"><xsl:value-of select="precio"/></td>
                            </tr>
                        </xsl:if>

                </xsl:for-each>
            </table>
        </xsl:template>

</xsl:stylesheet>