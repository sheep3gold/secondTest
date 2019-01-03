package com.itcast.thread;

public class SessionHandler {
    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public Session createSession() {
        return new Session();
    }

    public String getUser(Session session) {
        return session.getUser();
    }

    public String getStatus(Session session) {
        return session.getStatus();
    }

    public void setStatus(Session session, String status) {
        session.setStatus(status);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SessionHandler handler = new SessionHandler();
            Session session = handler.createSession();
            handler.getStatus(session);
            System.out.println(handler.getUser(session));
            handler.setStatus(session, "close");
            System.out.println(handler.getStatus(session));
        }).start();
    }
}
