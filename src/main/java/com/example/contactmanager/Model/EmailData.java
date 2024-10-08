package com.example.contactmanager.Model;

public class EmailData {
    private String recipient;
    private String mngBody;
    private String subject;
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getMngBody() {
        return mngBody;
    }
    public void setMngBody(String mngBody) {
        this.mngBody = mngBody;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public EmailData() {
    }
    public EmailData(String recipient, String mngBody, String subject) {
        this.recipient = recipient;
        this.mngBody = mngBody;
        this.subject = subject;
    }
    @Override
    public String toString() {
        return "EmailData [recipient=" + recipient + ", mngBody=" + mngBody + ", subject=" + subject + "]";
    }
}
