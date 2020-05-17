package com.bolsadeideas.springboot.backend.apirest.auth;

public class JwtConfig {
	
	public static final String KEY_SECRET = "alguna.clave.secreta.12345678";
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEogIBAAKCAQEAoQtfWcPcoDio2gSY06DQlbqs6EHo1QwFhFKiMF6kXlkmhbZW\r\n" + 
			"GVWjE5wcrpGxQOMF6eww63oolyzUuE9nKhQQCrcYiafSd4wOeROQLawwzBA4wG4T\r\n" + 
			"WLTcUzaYqdi4RsJTUnyaNu1yqgS6goG3gyXlDK5mnQCc4B8LM9B9Jl+Wh9ZuUj6b\r\n" + 
			"cHDDvC8Bcj/GwLrLkiaCXXW7BAEuaQvgoGPQQeTkdxoIxIlh01lhcW0uEHy9aPlM\r\n" + 
			"41NlO59cuEnn1YZlKyG+UNNEchxL8/5TrrD/gMdxGiqWk7fm/3ZckkRBesksoV4e\r\n" + 
			"8VkWXLRwfDs5QnSltsSGZQ0F5ygMmUG1yzvTNwIDAQABAoIBAHcZxgbJB12nCZlT\r\n" + 
			"VQMOJ7TUPhP2yo7lOR9HTZOgKsdr/0VcOAi8gMJ77epc7U4jl7gMaZF84pALI7a7\r\n" + 
			"YnyIIeUKzCbh6pFnDz0T7skYU25XgOEvhzdParJP6k+Sa5ZJGP4kEJkWunpqzNS/\r\n" + 
			"wkxHtkHOqSzryxklXE+RnTzH7Le//XqM+zTZyh1eySTM6fMKj2sYP+c/f0Uf0fZD\r\n" + 
			"MT0ErsopHVvOUX8LTqPkJgDLJZRwRANKU/XPsSGNi/xctOo9yfkNx1HTqeLErYON\r\n" + 
			"3K5oelU6uO8xUILaQNlL8e9Y3cdynHxsyd6F7FOCbVtmZT7rOFq9q24LatUMIyYG\r\n" + 
			"wmcYkGECgYEA04CikhLfSgwA+FGqAFAnji+38MuRWyh58a8nPHxCVEmOvdK03JxL\r\n" + 
			"nn8fqxlGMK4vbgQ4UPYSBAT5GZbTARTFjCIHHqU9kMAi/GbRTNEl+Fg9Wr9cmXds\r\n" + 
			"WCPoRsw2MDe+aQZKN871kOnumPb8KV9bpK+UHzuBT3yEM1tbVpRqq+MCgYEAwu0a\r\n" + 
			"tPO8dC2r5inpmAtZ81h2KJymKYktvyJcmtgP7a77n3GFs6O/WWaXbFSN+Rjqv6qm\r\n" + 
			"3+lDn/SBuZTmjXlvKxmrTUEr9gsYucHkU45k2NEsGfp+jS1PJrktOGJMSBCGRl40\r\n" + 
			"ARp8/F3XmvsjYb+kvnzbkLM9HT2qVWq41xocQ50CgYA5AJ9QHTP+4fNU+bWGthOj\r\n" + 
			"F6tMg6DeX69V+u3pOFgsHVMSR/qkxp7+zaY8V+h58EgqL4r6DwfV+30jb2nZDb8c\r\n" + 
			"QIOIt+I64/3J5vAb8vZ301hd39tWJUCXFL5ibmFgZ3WzGpXgKrA2aUX8Bfz6LZAm\r\n" + 
			"d4fFTyVPxfBfYwzf7co+HwKBgGwneNkMH/VqXeWwPa8iJT+zRqRT/pIvThWuMCmu\r\n" + 
			"VnAv1edq6p947LPjC4ONCtU6sQ211y+H0wDOfqgE6UN4LGmCrZyI26aCE68F2PVP\r\n" + 
			"nb77mHe1mEAm8rLurhuJ1v9pQ8eJf1tZYh34x6dzTvduiS80QfNwsCkoTPll5Ldd\r\n" + 
			"Am+1AoGATwO4gr0Vd3fHQebyUpkspglfbnR6H+8aAsj9UOCwzJ1vFnJsfO876/d8\r\n" + 
			"v7COsMCe0qg/sw9e2tvxjyQ+/+f0+Us61qw27mvSd8YDIYZWwHeH/tGl+nqTOdYV\r\n" + 
			"eO5ygZ+ZIeDsPx2PeWixZz19DEtrPLl6khEPfFDJJSjOOe4FXZs=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoQtfWcPcoDio2gSY06DQ\r\n" + 
			"lbqs6EHo1QwFhFKiMF6kXlkmhbZWGVWjE5wcrpGxQOMF6eww63oolyzUuE9nKhQQ\r\n" + 
			"CrcYiafSd4wOeROQLawwzBA4wG4TWLTcUzaYqdi4RsJTUnyaNu1yqgS6goG3gyXl\r\n" + 
			"DK5mnQCc4B8LM9B9Jl+Wh9ZuUj6bcHDDvC8Bcj/GwLrLkiaCXXW7BAEuaQvgoGPQ\r\n" + 
			"QeTkdxoIxIlh01lhcW0uEHy9aPlM41NlO59cuEnn1YZlKyG+UNNEchxL8/5TrrD/\r\n" + 
			"gMdxGiqWk7fm/3ZckkRBesksoV4e8VkWXLRwfDs5QnSltsSGZQ0F5ygMmUG1yzvT\r\n" + 
			"NwIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
