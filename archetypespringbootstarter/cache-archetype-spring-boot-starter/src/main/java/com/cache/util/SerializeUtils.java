package com.cache.util;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;


/**
 *   google proto buf
 *   更小的内存占用
 *   大数据可以考虑用这个来存储
 *   节省 redis 内存
 *   并且序列化速度比 json 更快
 *   缺点是在GUI工具内无法可视化
 * */
public class SerializeUtils{

    public static <T> byte[] serialize(T t,Class<T> clazz) {
        return ProtobufIOUtil.toByteArray(t, RuntimeSchema.createFrom(clazz),
                LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }
    public static <T> T deSerialize(byte[] data,Class<T> clazz) {
        RuntimeSchema<T> runtimeSchema = RuntimeSchema.createFrom(clazz);
        T t = runtimeSchema.newMessage();
        ProtobufIOUtil.mergeFrom(data, t, runtimeSchema);
        return t;
    }
}
