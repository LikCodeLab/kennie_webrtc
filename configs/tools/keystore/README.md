# 签名所需信息

## 常用命令

控制台输入命令: keytool -list -v -keystore apk 的 jks 

调试版本使用指令：keytool -list -v -keystore debug.jks

## Debug 签名信息

> 密码：123456

```xml
别名: debug
创建日期: 2021-8-22
条目类型: PrivateKeyEntry
证书链长度: 1
证书[1]:
所有者: CN=kennie, OU=kennie, O=kennie, L=NanJing, ST=JiangSu, C=86
发布者: CN=kennie, OU=kennie, O=kennie, L=NanJing, ST=JiangSu, C=86
序列号: 5618f0c1
生效时间: Sun Aug 22 22:16:52 CST 2021, 失效时间: Fri Aug 21 22:16:52 CST 2026
证书指纹:
         SHA1: 54:98:E2:5C:81:62:FF:12:47:B0:4E:75:83:85:35:1D:E3:A8:EF:37
         SHA256: 50:78:C1:37:D7:D2:AB:86:34:D0:A0:B6:07:92:00:EF:BD:2E:B3:99:C5:C5:18:E9:8D:BC:59:54:53:88:C0:E1
签名算法名称: SHA256withRSA
主体公共密钥算法: 2048 位 RSA 密钥
版本: 3
```


## Release 签名信息

> 密码：123456

```xml
别名: release
创建日期: 2021-8-22
条目类型: PrivateKeyEntry
证书链长度: 1
证书[1]:
所有者: CN=kennie, OU=kennie, O=kennie, L=NanJing, ST=JiangSu, C=86
发布者: CN=kennie, OU=kennie, O=kennie, L=NanJing, ST=JiangSu, C=86
序列号: 6246025a
生效时间: Sun Aug 22 22:17:35 CST 2021, 失效时间: Fri Aug 21 22:17:35 CST 2026
证书指纹:
         SHA1: 44:CD:96:C3:00:D3:62:D7:AD:52:09:B0:00:D4:DE:EC:60:F7:AF:82
         SHA256: CC:C4:27:51:27:35:F0:5A:E9:34:1C:02:5F:15:3B:B8:32:CF:EA:0A:44:1E:BF:AF:44:0B:C2:47:B9:02:74:CC
签名算法名称: SHA256withRSA
主体公共密钥算法: 2048 位 RSA 密钥
版本: 3

```
