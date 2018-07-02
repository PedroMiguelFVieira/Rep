<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>
	<label class="">Coordenadas ponto inicial:</label>
	<span>${itineraryInfo.initialCoordinates}</span><br/>

	<label>Coordenadas ponto final:</label>
	<span>${itineraryInfo.finalCoordinates}</span><br/>

	<label>Distancia:</label>
	<span>${itineraryInfo.distance}</span><br/>

	<label>Duracao:</label>
	<span>${itineraryInfo.duration}</span><br/>
	
	<label>Consumo Combinado:</label>
	<span>${itineraryInfo.averateConsumption}</span><br/>
	
</div>