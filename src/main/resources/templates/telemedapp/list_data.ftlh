<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>PatientData</title>
</head>
<style>
    table {table-layout: ;width: 80% ;style="overflow-x:auto;"}
    body {margin-left:20px;}
</style>

<body>

    <br>
    <p style="font-weight: bold;">Ime i prezime:</p><br><br>

    <p style="font-weight: bold;">Korisnik:</p>
    ${mail}
    <br><br>


    <p style="font-weight: bold;">Zapisi:</p><br>
    <div style="overflow-x:auto;">
    <table border="2" cellspacing="2" cellpadding="10">
        <tr style="height:50px">
            <th>Datum</th>
            <th>Sistolički tlak</th>
            <th>Dijastolički tlak</th>
            <th>Opis stanja</th>
        </tr>
        <#foreach record in recordList>
        <tr>
            <td>${record.timestamp?string["dd.MM.yyyy HH:mm"]}</td>
            <td>${record.bloodPressure1}</td>
            <td>${record.bloodPressure2}</td>
            <td>${record.description}</td>
        </tr>
    </#foreach>
    </table>
</div>
</body>

</html>