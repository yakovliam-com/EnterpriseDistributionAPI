# FadeCloud Distribution API

This project is FadeCloud's advanced multi-server distribution API that is implemented in specific projects

# How To Commit

When making commits, please use the [Commitzen Conventional Commit Standards](https://github.com/commitizen/conventional-commit-types/blob/master/index.json).

Adhering to these standards allows us to effectively communicate implied information through commit messages which promotes
a great work ethic and ease-of-fixing issues.

# How It's Supposed To Work

Below is a loose example of how the project is supposed to be integrated into other projects.
```
FadeDistributionAPI
    |- api
            |- Stuff
            |- RedisPacket
    |- proxy
        |- ProxyDistributedCommand
    |- backend
        |- BackendDistributedCommand

FadeDistribution[Gamemode Name]
    |- api (compile FadeDistributionAPI:api)
        |- [Gamemode Name]RedisPacket (extends RedisPacket)
    |- proxy-plugin (compile :api & FadeDistributionAPI:proxy)
        |- sends/receives [Gamemode Name]RedisPacket
    |- paper-plugin  (compile :api & FadeDistributionAPI:backend)
        |- sends/receives [Gamemode Name]RedisPacket

```