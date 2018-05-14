<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <xsl:apply-templates />
        </html>
    </xsl:template>
    <xsl:template match="motos">
        <table border="3px">
        <xsl:for-each select="moto">
            <xsl:sort  select="precio" data-type="number" order="descending"></xsl:sort>
            <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><img width="500" </td>
            </tr>
        </xsl:for-each>
        </table>
    </xsl:template>

</xsl:stylesheet>