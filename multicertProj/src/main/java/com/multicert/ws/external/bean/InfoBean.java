package com.multicert.ws.external.bean;

public  class InfoBean {		
	
	private String statusCode;
	private String messages;
	private Copyright copyright;	
	
	
	public static class Copyright{
		
		private String imageUrl;
		private String imageAltText;
		private String text;
		
		
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getImageAltText() {
			return imageAltText;
		}
		public void setImageAltText(String imageAltText) {
			this.imageAltText = imageAltText;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
	}
	
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public Copyright getCopyright() {
		return copyright;
	}
	public void setCopyright(Copyright copyright) {
		this.copyright = copyright;
	}

	
}
