<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/ol.css'/>"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <style>
        h2 {
            margin: 0;
        }

        .map {
            width: 100%;
            height: 700px;
        }

        #mapTitle {
            font-weight: bold;
            font-size: 30px;
            padding: 0px 0px 30px 0px;
            background-color: white;
            border: none;
            text-align: center;
        }
    </style>
    <script src="https://openlayers.org/en/v3.20.1/build/ol.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/proj4js/2.5.0/proj4-src.js"></script>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo">Hello!</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <c:if test="${not empty sessionScope.id}">
            <li><a href="<c:url value='/login/logout'/>">logout</a></li>
        </c:if>
        <c:if test="${empty sessionScope.id}">
            <li><a href="<c:url value='/login/login'/>">login</a></li>
            <li><a href="<c:url value='/login/add'/>">Sign in</a></li>
        </c:if>
        <li><a href=""><i class="fa fa-search"></i></a></li>
    </ul>
</div>
<div style="text-align:center">
    <%--3F9FBEBB-2FBF-396A-B8F9-22C67E40A94F--%>
    <div id="mapTitle">My Map</div>
    <div>
        <input type="checkbox" id="sido"/>시도
        <input type="checkbox" id="ssg"/>시군구
        <input type="checkbox" id="umd"/>읍면동
    </div>
    <div id="map" class="map"></div>
    <script type="text/javascript">
        // define epsg:5181 projection
        proj4.defs(
            "EPSG:5181",
            "+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=500000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs"
        );
        ol.proj.setProj4 = proj4;

        var resolutions = [
            2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1, 0.5, 0.25,
        ];
        var extent = [-30000, -60000, 494288, 988576];

        var projection = new ol.proj.Projection({
            code: "EPSG:5181",
            extent: extent,
            units: "m",
        });

        // define tile layer
        var tileLayer = new ol.layer.Tile({
            title: "Daum Street Map",
            visible: true,
            type: "base",
            source: new ol.source.XYZ({
                projection: projection,
                tileSize: 256,
                minZoom: 0,
                maxZoom: resolutions.length - 1,
                tileGrid: new ol.tilegrid.TileGrid({
                    origin: [extent[0], extent[1]],
                    resolutions: resolutions,
                }),
                tileUrlFunction: function (tileCoord, pixelRatio, projection) {
                    if (tileCoord == null) return undefined;

                    var s = Math.floor(Math.random() * 4); // 0 ~ 3
                    var z = resolutions.length - tileCoord[0];
                    var x = tileCoord[1];
                    var y = tileCoord[2];

                    return (
                        "https://map" +
                        s +
                        ".daumcdn.net/map_2d/2111ydg/L" +
                        z +
                        "/" +
                        y +
                        "/" +
                        x +
                        ".png"
                    );
                    // 원래 코드 return 'http://map' + s + '.daumcdn.net/map_2d/2fso49/L' + z + '/' + y + '/' + x + '.png';
                    // 복사한 코드 https://map2.daumcdn.net/map_2d_hd/2111ydg/L6/229/114.png
                },
                attributions: [
                    new ol.Attribution({
                        html: [
                            '<a href="http://map.daum.net"><img src="http://i1.daumcdn.net/localimg/localimages/07/mapjsapi/m_bi.png"></a>',
                        ],
                    }),
                ],
            }),
        });

        var wmsLayer = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                url: "http://localhost:8088/geoserver/boundary/wms",
                params: {
                    VERSION: "1.1.0",
                    LAYERS: "boundary:z_ngii_n3a_g0010000",
                    BBOX: [22537.658203125, -42034.9921875, 632508.8125, 545439.375],
                    SRS: "EPSG:5181",
                    FORMAT: "image/png",
                },
                serverType: "geoserver",
            }),
        });

        var map = new ol.Map({
            target: "map",
            layers: [tileLayer],
            view: new ol.View({
                center: ol.proj.fromLonLat([127, 38]),
                zoom: 7,
            }),
            view: new ol.View({
                projection: projection,
                extent: extent,
                resolutions: resolutions,
                maxResolution: resolutions[0],
                zoomFactor: 1,
                center: [248403, 272948],
                zoom: 1,
            }),
        });
        map.addLayer(wmsLayer);
    </script>
</div>
</body>
</html>