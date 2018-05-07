/* SystemJS module definition */
interface Window { Quill: any; }

declare var window: Window;
declare var module: NodeModule;
declare var require: NodeRequire;
interface NodeModule {
  id: string;
}
