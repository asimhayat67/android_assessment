package com.example.senthil.kotlin_navigationdrawer.data


data class ExpandableItem(val title: String, val children: List<String>, var isExpended: Boolean)

val topLevelItems = listOf(
    ExpandableItem(
        "Allgemeine Fragen: kurz und knapp beantwortet",
        listOf(
            "Was ist eine flächendeckende und gemeindeübergreifende Netzdetailplanung?",
            "Welche Vorteile haben die Kom- munen und Kommunalverbände von der Netzdetailplanung?",
            "Welche Kosten kommen für die Erstellung der Netzdetailplanun- gen auf die Landkreise und deren Kommunen zu?"
        ), true
    ),
    ExpandableItem(
        "Adresspunktvalidierung & Datenlieferung",
        listOf(
            "Welche Vorteile haben die Kom- munen und Kommunalverbände",
            "Was ist eine flächendeckende und gemeindeübergreifende",
            "Welche Kosten kommen für die Erstellung der Netzdetailplanun"
        ), true
    ),
    // Add more items as needed
)