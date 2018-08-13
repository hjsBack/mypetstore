<%--
  Created by IntelliJ IDEA.
  User: songtie
  Date: 2015/4/21
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        Welcome to MyPetStore!
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br/> Saltwater, Freshwater <br/>
            <a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br /> Various Breeds <br />
            <a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br /> Various Breeds, Exotic Varieties <br />
            <a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br /> Lizards, Turtles, Snakes <br />
            <a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br /> Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" id="Birds1" title="Birds" shape="rect" />
                <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" id="Fish" title="Fish" shape="rect" />
                <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" id="Dogs" title="Dogs" shape="rect" />
                <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" id="Reptiles=" title="Reptiles" shape="rect" />
                <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" id="Cats" title="Cats" shape="rect" />
                <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" id="Birds2" title="Birds" shape="rect" />
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>

    <script>
        jQuery(document).ready(function($) {
            $('.tooltip').simpletooltip({
                themes: {
                    pink: {
                        color: 'red',
                        border_color: 'red',
                        background_color: 'pink',
                        border_width: 4
                    },
                    brazil: {
                        color: 'yellow',
                        background_color: 'green',
                        border_color: 'yellow',
                        border_width: 4
                    }
                }
            });
        });
    </script>
    <div id="Separator">&nbsp;</div>
</div>

<%@include file="../common/IncludeBottom.jsp"%>