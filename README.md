# Enterprise Distribution API

This project is Jacob's advanced multi-server distribution API that is implemented in specific projects

# How To Commit/Contribute

When fixing bugs/adding features, please make a new branch while following [Digitaljhelms's branch standards](https://gist.github.com/digitaljhelms/4287848).

When making commits, please use the [Commitzen Conventional Commit Standards](https://github.com/commitizen/conventional-commit-types/blob/master/index.json).

Adhering to these standards allows us to effectively communicate implied information through commit messages which promotes
a great work ethic and ease-of-fixing issues.

# How It's Supposed To Work

Below is a loose example of how the project is supposed to be integrated into other projects.
```
EnterpriseDistributionAPI
    |- api
            |- Stuff
            |- RedisPacket
    |- proxy
        |- Proxy Specific Stuff
    |- backend
        |- Backend Specific Stuff

EnterpriseDistribution[Gamemode Name]
    |- api (compile EnterpriseDistributionAPI:api)
        |- [Gamemode Name]RedisPacket (extends RedisPacket)
    |- proxy-plugin (compile :api & EnterpriseDistributionAPI:proxy)
        |- sends/receives [Gamemode Name]RedisPacket
    |- paper-plugin  (compile :api & EnterpriseDistributionAPI:backend)
        |- sends/receives [Gamemode Name]RedisPacket
```
