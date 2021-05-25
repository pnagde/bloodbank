<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://java.sun.com/jsp/jstl/core"%>

<sp:set var="req" value="${pageContext.request}" />
<sp:set var="path" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link
      href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
      rel="stylesheet"
    />

    <title>Blood Bank</title>
    <!-- Bootstrap core CSS -->
    <link href="${path}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="${path}/assets/css/fontawesome.css" />
    <link rel="stylesheet" href="${path}/assets/css/templatemo-style.css" />
    <link rel="stylesheet" href="${path}/assets/css/owl.css" />
    <link rel="stylesheet" href="${path}/assets/css/lightbox.css" />
    <script>
        var serverpath = "${path}";
    </script>
  </head>

  <body>