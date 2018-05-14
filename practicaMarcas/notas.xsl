<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    table{
                            border: 10px outset blue;
                            background-color: white;
                    }

                    td{
                        background-color: aqua;
                        border: 3px solid;
                        border-color: blue;
                    }
                    .color{
                        background-color: blue;
                        color: white;
                    }
                    .centrado{
                        text-align: center;
                    }

                    .titulo{
                    color: white;
                    }
                    .insuficiente{
                        color: red;
                    }
                    .negrita{
                        font-weight: bold;

                    }
                    .grande
                    {
                        font-size: medium;

                    }

                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="notas">
    <table border="3px">
        <tr class="centrado"><td class="color" colspan="6">Calificaciones</td></tr>
        <tr class="centrado"><td class="color" colspan="2">datos</td><td class="color" colspan="4">notas</td></tr>
        <tr><td class="titulo">Convocatoria</td><td class="titulo">Nombre</td><td class="titulo">Cuestionario</td><td class="titulo">Tareas</td><td class="titulo">Examen</td><td class="titulo">Final</td></tr>
        <xsl:for-each select="alumno">
            <xsl:if test="@convocatoria ='Junio'">
                <tr><td><xsl:value-of select="@convocatoria"/></td>
                    <td class="negrita"><xsl:value-of select="nombre"/><xsl:text> </xsl:text><xsl:value-of select="apellidos"/></td>
                    <td><xsl:value-of select="cuestionarios"/></td>
                    <td><xsl:value-of select="tareas"/></td>
                    <td><xsl:value-of select="examen"/></td>
                    <xsl:choose>
                        <xsl:when test="final &lt;5">
                            <td class="insuficiente">insuficiente</td>
                        </xsl:when>
                        <xsl:when test="final &gt;=5 and final &lt;7">
                            <td class="negrita">Suficiente</td>
                        </xsl:when>
                        <xsl:when test="final &gt;=7 and final &lt;9">
                            <td class="negrita">Notable</td>
                        </xsl:when>
                        <xsl:when test="final &gt;=9 and final &lt;=10">
                            <td class="negrita">Sobresaliente</td>
                        </xsl:when>
                    </xsl:choose>
                </tr>
            </xsl:if>
        </xsl:for-each>
    </table>
    </xsl:template>
</xsl:stylesheet>