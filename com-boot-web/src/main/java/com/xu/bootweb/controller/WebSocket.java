package com.xu.bootweb.controller;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p>
 *     利用 javax API 实现 webSocket
 * </p>
 * @author xuhongda on 2019/3/27
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Slf4j
@ServerEndpoint("ws")
public class WebSocket {

    /**
     * 线程安全的静态变量，表示在线连接数
     */
    private static volatile int onlineCount = 0;

    /**
     * 用来存放每个客户端对应的WebSocketTest对象，适用于同时与多个客户端通信
     */
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 若要实现服务端与指定客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     */
    private static ConcurrentHashMap<Session, Object> webSocketMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，通过它实现定向推送(只推送给某个用户)
     */
    private Session session;

    /**
     * 建立连接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // 添加到set中
        webSocketSet.add(this);
        // 添加到map中
        webSocketMap.put(session,this);
        // 添加在线人数
        addOnlineCount();
        System.out.println("新人加入，当前在线人数为："  + getOnlineCount());
    }

    /**
     * 关闭连接调用的方法
     */
    @OnClose
    public void onClose(Session closeSession){
        webSocketMap.remove(session);
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有人离开，当前在线人数为：" + getOnlineCount());
    }

    /**
     *  收到客户端小心调用的方法
     */
    @OnMessage
    public void onMessage(String message,Session mysession) throws Exception{
        for (WebSocket item:
                webSocketSet) {
            item.sendAllMessage(message);
        }
    }

    private void sendAllMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("webSocket发生错误！IP：{}", session);
        error.printStackTrace();
    }



    /**
     * 获取在线人数
     * @return int
     */
    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    /**
     * 添加在线人+1
     */
    private static synchronized void addOnlineCount(){
        onlineCount ++;
    }

    /**
     * 减少在线人-1
     */
    private static synchronized void subOnlineCount(){
        onlineCount --;
    }

}
