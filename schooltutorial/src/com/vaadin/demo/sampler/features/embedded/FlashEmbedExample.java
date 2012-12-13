package com.vaadin.demo.sampler.features.embedded;

import org.vaadin.youtubeplayer.YouTubePlayer;

import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class FlashEmbedExample extends VerticalLayout {

    public FlashEmbedExample() {
    	// Create a YouTubePlayer
    	YouTubePlayer player = new YouTubePlayer();
    	player.setVideoId("ynrtPZHwhvY?hd=1");
    	player.setWidth("600px");
    	player.setHeight("500px");
    	player.setAllowFullscreen(true);
    	addComponent(player);
    }
}