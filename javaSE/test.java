import com.finchina.example.entity.User;
import com.finchina.example.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;

public class SendMsgService {
    //多线程处理
    private static final ExecutorService executorService = Executors.newFixedThreadPool(50);
    @Resource
    UserService userService;
    @Resource
    RedisTemplate<String, String> redisTemplate;

    public void send(List<String> userIds) {
        List<User> userPhones  = userService.findAllPhone(UserIds);
        // 批量查询保存到set中
        Set<String> onlineUserKeys = redisTemplate.keys("online_*");
        for (User user : userPhones ) {
            String onlineKey = "online_" + user.getId();
            if (onlineUserKeys.contains(onlineKey)) {
                executorService.submit(() -> {
                    try {
                        sendMsg(user.getPhone());
                    } catch (Exception e) {
                        // 记录日志
                        System.err.println("推送失败，用户ID为" + user.getId() + "，异常：" + e.getMessage());
                        //重试机制
                        RetrySendMsg(user.getPhone());
                    }
                });
            }
        }
    }
}