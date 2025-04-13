package com.movieapp.dahp_ccptpm_be.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthChannelInterceptor implements ChannelInterceptor {
    @Autowired
    private JWTutils jwtutils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        // Lấy StompHeaderAccessor để truy cập các header trong message
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        // Kiểm tra nếu đây là CONNECT command
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            // Lấy header "Authorization"
            String authHeader = accessor.getFirstNativeHeader("Authorization");
            System.out.println("Authorization header nhận được: " + authHeader);

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                // Trích xuất token, loại bỏ phần "Bearer "
                String token = authHeader.substring(7);

                // TODO: Thực hiện xác thực token ở đây (ví dụ: sử dụng thư viện JWT)
                String username = jwtutils.extractUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                boolean isValid = jwtutils.isTokenValid(token, userDetails);
                if (!isValid) {
                    System.out.println("Token không hợp lệ");
                    throw new IllegalArgumentException("Token không hợp lệ");
                }

                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                accessor.setUser(authentication);
            } else {
                System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
            }
        }

        if (StompCommand.SEND.equals(accessor.getCommand())) {
            String destination = accessor.getDestination();
            if (destination.startsWith("/send/admin/")) {
                String token = getStringToken(accessor);

                if (token != null) {
                    boolean isValid = authorization(token, "admin");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/send/user/")) {
                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "user");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/private") && destination.endsWith("/user")) {

                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "user");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/private") && destination.endsWith("/admin")) {

                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "admin");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }
        }

        if (StompCommand.SUBSCRIBE.equals(accessor.getCommand())) {
            String destination = accessor.getDestination();

            if (destination.startsWith("/receive/admin/")) {
                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "admin");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/receive/user/")) {
                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "user");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/private") && destination.endsWith("/user")) {

                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "user");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }

            if (destination.startsWith("/private") && destination.endsWith("/admin")) {

                String token = getStringToken(accessor);
                if (token != null) {
                    boolean isValid = authorization(token, "admin");

                    if (!isValid) {
                        System.out.println("Người dùng không có quyền");
                        throw new IllegalArgumentException("Người dùng không có quyền");
                    }

                } else {
                    System.out.println("Token không tồn tại hoặc không hợp lệ trong header");
                    throw new IllegalArgumentException("Không tìm thấy token hợp lệ trong header Authorization");
                }
            }
        }

        return message;
    }

    private boolean authorization(String token, String role) {
        if (!validToken(token)) {
            System.out.println("Token không hợp lệ");
            throw new IllegalArgumentException("Token không hợp lệ");
        }

        if (!getRole(token).equals(role)) {
            return false;
        }

        return true;
    }

    private String getStringToken(StompHeaderAccessor accessor) {
        String authHeader = accessor.getFirstNativeHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Trích xuất token, loại bỏ phần "Bearer "
            String token = authHeader.substring(7);
            return token;
        }
        return null;
    }

    private boolean validToken(String token) {
        String username = jwtutils.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        boolean isValid = jwtutils.isTokenValid(token, userDetails);

        if (!isValid) {
            return false;
        }

        return true;
    }

    private String getRole(String token) {
        String username = jwtutils.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        GrantedAuthority[] authoritiesArray = userDetails.getAuthorities().toArray(new GrantedAuthority[0]);
        if (authoritiesArray.length > 0) {
            GrantedAuthority firstAuthority = authoritiesArray[0];
            return firstAuthority.getAuthority();
        }
        return null;
    }

}


